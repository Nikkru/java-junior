package stream_API.reflection_API.lection.seminar.task3;

import java.lang.reflect.Field;
import java.util.UUID;

public class QueryBuilder {
    public String buildInsertQuery(Object obj) throws IllegalAccessException {
        Class<?> _class = obj.getClass();
        StringBuilder query = new StringBuilder("INSERT INTO ");
        if (_class.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = _class.getAnnotation(Table.class);
            query
                    .append(tableAnnotation.name())
                    .append(" `(");
            Field[] fields = _class.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    query.append(columnAnnotation.name()).append(", ");
                }
            }

            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }

            query.append(") VALUES (");

            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    query.append("'").append(field.get(obj)).append("', ");
                }
            }

            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }

            query.append(")");
            return query.toString();
        } else {
            return null;
        }
    }

    public String buildSelectQuery(Class<?> class_, UUID primaryKey) {
        StringBuilder query = new StringBuilder("SELECT * FROM ");
        if (class_.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = class_.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" WERE ");

            Field[] fields = class_.getDeclaredFields();

            for (Field field : fields) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey()) {
                    query.append(columnAnnotation.name()).append(" = ").append(primaryKey);
                    break;
                }
            }
        }
        return query.toString();
    }

    public String buildUpdateQuery(Object obj) throws IllegalAccessException {
        Class<?> class_ = obj.getClass();
        StringBuilder query = new StringBuilder("UPDATE ");

        if (class_.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = class_.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" SET ");
            Field[] fields = class_.getDeclaredFields();

            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }

            query.append(" WHERE ");

            for (Field field : fields) {
                field.setAccessible(true);
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey())
                    query.append(columnAnnotation.name())
                            .append(" = '")
                            .append(field.get(obj))
                            .append("'");
                    break;
            }
                return query.toString();
        } else {
            return null;
        }
    }

    /*
     * TODO: Доработать в рамках домашней работы
     * @param clazz
     * @param primaryKey
     * @return
     */
    public String buildDeleteQuery(Class<?> clazz, UUID primaryKey) {
        StringBuilder query = new StringBuilder("DELETE * FROM ");
        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" WERE ");

            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey()) {
                    query.append(columnAnnotation.name()).append(" = ").append(primaryKey);
                    break;
                }
            }
        }
        return query.toString();
    }
}
