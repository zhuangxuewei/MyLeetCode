package com.sherwin.mystock.common.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

public class SqlTools {
	public <T> String buildUpdatePartSql(List<String> updateFieldList, String conditionFieldName,
			Collection<T> dataCollection) {
		if (dataCollection == null || dataCollection.size() == 0) {
			return "";
		}
		Iterator dataIterator = dataCollection.iterator();
		// 反射拿到类和字段的注解，获取表名和更新的字段名
		Class clazz = dataIterator.next().getClass();
		Table tableAnnotation = (Table) clazz.getAnnotation(Table.class);
		// 获取表名
		String tableName = tableAnnotation.name();
		if (StringUtils.isEmpty(tableName)) {
			return "";
		}
		StringBuilder sql = new StringBuilder();
		try {
			Field[] fields = clazz.getDeclaredFields();
			// 类字段和表字段映射
			Map<String, String> fieldColmnMap = new HashMap<String, String>();
			Map<String, Field> nameFieldMap = new HashMap<String, Field>();
			for (Field field : fields) {
				Column columnAnnotation = field.getAnnotation(Column.class);
				if (columnAnnotation == null) {
					continue;
				}
				fieldColmnMap.put(field.getName(), columnAnnotation.name());
				nameFieldMap.put(field.getName(), field);
			}
			sql.append("update ").append(tableName).append(" set ");
			String conditionColmn = fieldColmnMap.get(conditionFieldName);
			// when then 子句初始化
			Map<String, StringBuilder> whenThenSqlMap = new HashMap<String, StringBuilder>();
			updateFieldList.forEach(field -> {
				StringBuilder whenThenSql = new StringBuilder();
				whenThenSql.append(fieldColmnMap.get(field)).append(" = case " + conditionColmn + " ");
				whenThenSqlMap.put(field, whenThenSql);
			});
			Field conditionField = nameFieldMap.get(conditionFieldName);

			StringBuilder whereSql = new StringBuilder("where " + conditionColmn + " in (");
			// 遍历数据，组装sql到set 和where子句
			for (Iterator iterator = dataCollection.iterator(); iterator.hasNext();) {
				Object element = iterator.next();
				Object conditionValue = ReflectTools.getFieldValue(conditionField, element);
				String conditionValueSql = getValueSql(conditionValue);
				for (String fieldName : whenThenSqlMap.keySet()) {
					StringBuilder whenThenSql = whenThenSqlMap.get(fieldName);
					Field updateField = nameFieldMap.get(fieldName);
					Object fieldValue = ReflectTools.getFieldValue(updateField, element);
					whenThenSql.append("when ").append(conditionValueSql).append(" then ")
							.append(getValueSql(fieldValue)).append(" ");
				}
				if (iterator.hasNext()) {
					whereSql.append(getValueSql(conditionValue)).append(",");
				} else {
					whereSql.append(conditionValueSql);
				}

			}
			whereSql.append(")");
			for (Iterator iterator = whenThenSqlMap.keySet().iterator(); iterator.hasNext();) {
				String field = (String) iterator.next();
				if (iterator.hasNext()) {
					sql.append(whenThenSqlMap.get(field)).append(" end, ");
				} else {
					sql.append(whenThenSqlMap.get(field)).append(" end ");
				}
			}
			sql.append(whereSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql.toString();
	}

	private String getValueSql(Object conditionValue) {
		String sql = "";
		if (conditionValue instanceof String) {
			sql = "'" + conditionValue.toString() + "'";
		} else {
			sql = conditionValue.toString();
		}
		return sql;
	}
}
