/*
 * SQLBase.java
 *
 * Created on 2010/04/28
 *
 * @author: 
 *
 ****<< Modification Note >>
 */
package data.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public abstract class SQLiteBase
{
    //======================================
    // Declaration parameter
    //======================================
 
    // Database related
    protected Connection dbConnection = null;
    protected String sqlBatchCommands = "";
    protected int statementRunCount = 0;
    private ArrayList<Statement> statementList = new ArrayList<Statement>();
    private ArrayList<ResultSet> resultSetList = new ArrayList<ResultSet>();

    protected Calendar timeStamp;

    //======================================
    // Static activate process
    //======================================

    //======================================
    // Constructor
    //======================================

    public SQLiteBase()
    {
        super();
    }

    //======================================
    // Member Method
    //======================================
    /*
     * V2.0.8
     * Add a condition class for all SQL condition
     * Any SQL class need condition rule must be extends this class
     */
    public static class SQLCond{
        protected ArrayList<String> condFieldList = new ArrayList<String>();
        protected ArrayList<String> condValueList = new ArrayList<String>();
        protected ArrayList<String> condOpList = new ArrayList<String>();

        //V1.2.2
        /***
         * String
         */
        public void addStrCond(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condValueList.add("'" + value + "'");
            condOpList.add(SQL.EQUAL);
        }

        public void addStrNotEqualCond(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condValueList.add("'" + value + "'");
            condOpList.add(SQL.NOT_EQUAL);
        }

         //V2.0.0 Start
        public void addStrIsNullCond(String fieldName)
        {
            condFieldList.add(fieldName);
            condValueList.add(" null ");
            condOpList.add(SQL.ISNULL);
        }

        public void addStrIsNotNullCond(String fieldName)
        {
            condFieldList.add(fieldName);
            condValueList.add(" null");
            condOpList.add(SQL.ISNOTNULL);
        }
        //End V2.0.0
        public void addStrGreaterCond(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.GREATER);
            condValueList.add("'" + value + "'");
        }

        public void addStrBetweenCond(String fieldName, String fromValue, String toValue)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.BETWEEN);
            condValueList.add(fromValue + SQL.AND + toValue);
        }

        //V1.2.4
        /***
         * Number
         */
        public void addIntCond(String fieldName, int value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.EQUAL);
            condValueList.add("" + value);
        }

        public void addIntCond(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.EQUAL);
            condValueList.add(value);
        }

        public void addIntNotEqualCond(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.NOT_EQUAL);
            condValueList.add(value);
        }
        
        public void addCond(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.EQUAL);
            condValueList.add(value);
        }

        public void addNumCondGreater(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.GREATER);
            condValueList.add(value);
        }

        public void addNumCondLess(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.LESS);
            condValueList.add(value);
        }

        public void addNumCondGreaterEqual(String fieldName, String value)
        {
            condFieldList.add("to_number(" + fieldName + ")");
            condOpList.add(SQL.GREATEREQUAL);
            condValueList.add("to_number(" + value + ")");
        }

        public void addNumCondLessEqual(String fieldName, String value)
        {
            condFieldList.add("to_number(" + fieldName + ")");
            condOpList.add(SQL.LESSEQUAL);
            condValueList.add("to_number(" + value + ")");
        }

        public void addBetweenCond(String fieldName, int fromValue, int toValue)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.BETWEEN);
            condValueList.add(fromValue + SQL.AND + toValue);
        }

        //V1.0.8 Add Start
        public void addCond(SQLSingleOrCondition orCondition)
        {
            condFieldList.add(orCondition.toString());
            condValueList.add("");
            condOpList.add("");
        }

        //V1.0.8 Add End
        public void addCond(SQLOrCondition orCondition)
        {
            condFieldList.add(orCondition.toString());
            condValueList.add("");
            condOpList.add("");
        }

        /***
         * Time
         * @param fieldName
         * @param value
         */
        public void addTimeCond(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.EQUAL);
            condValueList.add("TO_DATE('" + value + "','YYYY/MM/DD HH24:MI:SS')");
        }

        public void addTimeCondGreater(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.GREATER);
            condValueList.add("TO_DATE('" + value + "','YYYY/MM/DD HH24:MI:SS')");
        }

        public void addTimeCondLess(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.LESS);
            condValueList.add("TO_DATE('" + value + "','YYYY/MM/DD HH24:MI:SS')");
        }

        public void addTimeCondGreaterEquall(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condValueList.add("TO_DATE('" + value + "','YYYY/MM/DD HH24:MI:SS')");
            condOpList.add(SQL.GREATEREQUAL);
        }

        public void addTimeCondLessEqual(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condValueList.add("TO_DATE('" + value + "','YYYY/MM/DD HH24:MI:SS')");
            condOpList.add(SQL.LESSEQUAL);
        }

        public void addTimeBetweenCond(String fieldName, Date fromTime, Date toTime)
        {
            addTimeBetweenCond(fieldName, changeDT(fromTime), changeDT(toTime));
        }
        public void addDateBetweenCond(String fieldName, Date fromTime, Date toTime)
        {
            addDateBetweenCond(fieldName, changeDT(fromTime,"yyyy-MM-dd"), changeDT(toTime,"yyyy-MM-dd"));
        }
        
        public void addTimeInTodayCond(String fieldName)
        {
            condFieldList.add(fieldName);
            String cond = "date('now', '-1 days') and "
                    + "date('now', '+1 days');";
            condValueList.add(cond);
            condOpList.add(SQL.BETWEEN);
        }
        
        public void addDateBetweenCond(String fieldName, String fromTime, String toTime)
        {
            condFieldList.add(fieldName);
            String cond = "'"
                    + fromTime
                    + "' and '"                    
                    + toTime
                    + "'";
            condValueList.add(cond);
            condOpList.add(SQL.BETWEEN);
        }

        public void addTimeBetweenCond(String fieldName, String fromTime, String toTime)
        {
            condFieldList.add(fieldName);
            String cond = "TO_DATE('"
                    + fromTime
                    + "','YYYY/MM/DD HH24:MI:SS') and "
                    + "TO_DATE('"
                    + toTime
                    + "','YYYY/MM/DD HH24:MI:SS')";
            condValueList.add(cond);
            condOpList.add(SQL.BETWEEN);
        }

        /***
         * Timestamp
         * @param fieldName
         * @param value
         */
        public void addTimestampCond(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condValueList.add("TO_TIMESTAMP('" + value + "','YYYY/MM/DD HH24:MI:SS.FF')");
            condOpList.add(SQL.EQUAL);
        }

        //V2.0.8
        public void addTimestampCondGreater(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condValueList.add("TO_TIMESTAMP('" + value + "','YYYY/MM/DD HH24:MI:SS.FF')");
            condOpList.add(SQL.GREATER);
        }

        //V2.0.8
        public void addTimestampCondGreaterEqual(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condValueList.add("TO_TIMESTAMP('" + value + "','YYYY/MM/DD HH24:MI:SS.FF')");
            condOpList.add(SQL.GREATEREQUAL);
        }

        //V2.0.8
        public void addTimestampCondLess(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condValueList.add("TO_TIMESTAMP('" + value + "','YYYY/MM/DD HH24:MI:SS.FF')");
            condOpList.add(SQL.LESS);
        }

        //V2.0.8
        public void addTimestampCondLessEqual(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condValueList.add("TO_TIMESTAMP('" + value + "','YYYY/MM/DD HH24:MI:SS.FF')");
            condOpList.add(SQL.LESSEQUAL);
        }

        /***
         * In
         * @param fieldName
         * @param value
         */
        public void addInCond(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.IN);
            condValueList.add("(" + value + ")");
        }

        /***
         * Like
         * @param fieldName
         * @param value
         */
        public void addLikeCond(String fieldName, String value)
        {
            condFieldList.add(fieldName);
            condOpList.add(SQL.LIKE);
            condValueList.add("'" + value + "'");
        }
        
        public String getCoditction(){
            StringBuffer buff=new StringBuffer();
            if (condFieldList.size() == 0)
            {
                addCond("1", "1");
            }

            for (int i = 0; i < condFieldList.size(); i++)
            {
                buff.append(condFieldList.get(i).toString());
                buff.append(condOpList.get(i).toString());
                buff.append(condValueList.get(i).toString());
                buff.append(SQL.AND);
            }
            buff.delete(buff.lastIndexOf(SQL.AND), buff.lastIndexOf(SQL.AND) + SQL.AND.length());
            return buff.toString();

        }
    }

    /*
     * V2.0.8
     * extends SQLCond and remove condition properties
     * getCoditction - get condition string
     */
    // Select Class
    public static class SQLSelecter extends SQLCond
    {

        private String tableName;
        private ArrayList<String> fieldList = new ArrayList<String>();
        private ArrayList<String> orderByList = new ArrayList<String>();
        private ArrayList<String> groupByList = new ArrayList<String>();

        public SQLSelecter(String tableName)
        {
            this.tableName = tableName;
        }

        public SQLSelecter(SQLSelecter selecter, String tableName)
        {
            this.tableName = "(" + selecter.toString() + ") " + tableName;
        }

        //V2.0.3
        public void setTableName(String tableName)
        {
            this.tableName = tableName;
        }

        public void addSelect(String fieldName)
        {
            fieldList.add(fieldName);
        }

        //V2.0.5
        public void addSelectDistinct(String fieldName)
        {
            fieldList.add(SQL.Distinct + fieldName);
        }

        //V1.2.2
        public void addSelectMax(String fieldName)
        {
            fieldList.add(SQL.MAX + SQL.L_PARENTHESIS + fieldName + SQL.R_PARENTHESIS);
        }

        //V1.2.2
        public void addSelectMin(String fieldName)
        {
            fieldList.add(SQL.MIN + SQL.L_PARENTHESIS + fieldName + SQL.R_PARENTHESIS);
        }

        //V1.2.6 start
        public void addSelectSum(String fieldName)
        {
            fieldList.add(SQL.SUM + SQL.L_PARENTHESIS + fieldName + SQL.R_PARENTHESIS);
        }

        public void addSelectSum(String fieldName, String valueName)
        {
            fieldList.add(SQL.SUM + SQL.L_PARENTHESIS + fieldName + SQL.R_PARENTHESIS + " as " + valueName);
        }
        //V1.2.6 end

        public void addStr(String strValue)
        {
            fieldList.add("'" + strValue + "'");
        }

        public void addInt(String strValue)
        {
            fieldList.add(strValue);
        }

        public void addTimeSelect(String fieldName)
        {
            fieldList.add("TO_CHAR(" + fieldName + ",'YYYY/MM/DD HH24:MI:SS') as " + fieldName);
        }

        public void addTimeSelect(String fieldName, String valueName)
        {
            fieldList.add("TO_CHAR(" + fieldName + ",'YYYY/MM/DD HH24:MI:SS') as " + valueName);
        }

        public void addBCPTimeSelect(String fieldName, String valueName)// 2.1.0
        {
            fieldList.add("TO_CHAR(" + fieldName + ",'YY-MM-DD HH24:MI:SS') as " + valueName);
        }

        public void addTimestampSelect(String fieldName)
        {
            fieldList.add("TO_CHAR(" + fieldName + ",'YYYY/MM/DD HH24:MI:SS.FF') as " + fieldName);
        }

        public void addTimestampSelect(String fieldName, String valueName)
        {
            fieldList.add("TO_CHAR(" + fieldName + ",'YYYY/MM/DD HH24:MI:SS.FF') as " + valueName);
        }

        public void addRoundSelect(String fieldName, String valueName, int idx)
        {
            fieldList.add("round(nvl(" + fieldName + ",0)," + idx + ") as " + valueName);
        }


        public void addOrder(String fieldName)
        {
            orderByList.add(fieldName);
        }

        public void addOrderDesc(String fieldName)
        {
            orderByList.add(fieldName + SQL.DESC);
        }

        public void addGroup(String fieldName)
        {
            groupByList.add(fieldName);
        }

        public String toString()
        {
            StringBuffer sbRtn = new StringBuffer();

            sbRtn.append(SQL.SELECT);

            // Specify the fields to be selected
            for (int i = 0; i < fieldList.size(); i++)
            {
                sbRtn.append(fieldList.get(i) + SQL.COMMA);
            }
            // remove the trailing comma
            sbRtn.deleteCharAt(sbRtn.lastIndexOf(SQL.COMMA));
            // set condition
            sbRtn.append(SQL.FROM + tableName + SQL.WHERE);
            sbRtn.append(this.getCoditction());

            if (groupByList.size() > 0)
            {
                sbRtn.append(SQL.GROUP_BY);
                for (int i = 0; i < groupByList.size(); i++)
                {
                    sbRtn.append(groupByList.get(i) + SQL.COMMA);
                }
                // remove the trailing comma
                sbRtn.deleteCharAt(sbRtn.lastIndexOf(SQL.COMMA));
            }

            if (orderByList.size() > 0)
            {
                sbRtn.append(SQL.ORDER_BY);
                for (int i = 0; i < orderByList.size(); i++)
                {
                    sbRtn.append(orderByList.get(i) + SQL.COMMA);
                }
                // remove the trailing comma
                sbRtn.deleteCharAt(sbRtn.lastIndexOf(SQL.COMMA));
            }

            return sbRtn.toString();
        }
    }
    /*
     * V2.0.8
     * Add setTableName method
     * Add getSelector function
     */
    // Insert from select Class
    public static class SQLSelectInserter
    {
        private String insertTable;
        private SQLSelecter selecter;
        private ArrayList<String> insertFields = new ArrayList<String>();

        public SQLSelectInserter(String insertTable, String selectTable)
        {
            this.insertTable = insertTable;
            selecter = new SQLSelecter(selectTable);
        }

        public void setTableName(String tableName)
        {
            this.insertTable = tableName;
        }

        public void addField(String insertField, String selectField)
        {
            insertFields.add(insertField);
            selecter.addSelect(selectField);
        }

        public void addStr(String insertField, String strValue)
        {
            insertFields.add(insertField);
            selecter.addStr(strValue);
        }

        public void addInt(String insertField, String value)
        {
            insertFields.add(insertField);
            selecter.addInt(value);
        }

        public void addSysdate(String insertField)
        {
            insertFields.add(insertField);
            selecter.addInt("sysdate");
        }

        public void addSystimestamp(String insertField)
        {
            insertFields.add(insertField);
            selecter.addInt("systimestamp");
        }

        public void addField(String field)
        {
            insertFields.add(field);
            selecter.addSelect(field);
        }

        public void addStrCond(String fieldName, String value)
        {
            selecter.addStrCond(fieldName, value);
        }

        public void addCond(String fieldName, String value)
        {
            selecter.addCond(fieldName, value);
        }

        public void addCond(SQLOrCondition orCondition)
        {
            selecter.addCond(orCondition);
        }

        public void addTimeCond(String field, String value)
        {
            selecter.addTimeCond(field, value);
        }

        public void addTimestampCond(String field, String value)
        {
            selecter.addTimestampCond(field, value);
        }

        //V1.0.6 
        public void addTimeCondLess(String fieldName, String value)
        {
            selecter.addTimeCondLess(fieldName, value);
        }

        //V1.0.6
        public void addInCond(String fieldName, String value)
        {
            selecter.addInCond(fieldName, value);
        }

        public SQLSelecter getSelector(){
            return this.selecter;
        }

        public String toString()
        {
            String rtnString = "";

            rtnString = SQL.INSERT + insertTable + SQL.SPACE;
            rtnString = rtnString + "(";
            for (int i = 0; i < insertFields.size(); i++)
            {
                rtnString = rtnString + insertFields.get(i).toString() + SQL.COMMA;
            }
            rtnString = rtnString.substring(0, rtnString.length() - SQL.COMMA.length());
            rtnString = rtnString + ")" + SQL.SPACE;

            rtnString = rtnString + selecter.toString();

            return rtnString;
        }

    }

    // Insert Class
    public static class SQLInserter
    {
        private String tableName;
        private ArrayList<String> fieldList = new ArrayList<String>();
        private ArrayList<String> valueList = new ArrayList<String>();

        public SQLInserter(String tableName)
        {
            this.tableName = tableName;
        }

        public void setTableName(String tableName)
        {
            this.tableName = tableName;
        }

        public void addStrValue(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("'" + value + "'");
        }

        public void addValue(String fielName, String value)
        {
            fieldList.add(fielName);
            valueList.add("" + value);
        }

        public void addIntValue(String fieldName, int value)
        {
            fieldList.add(fieldName);
            valueList.add("" + value);
        }

        //V1.0.9
        public void addLongValue(String fieldName, long value)
        {
            fieldList.add(fieldName);
            valueList.add("" + value);
        }

        public void addIntValue(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("" + value);
        }

        public void addDoubleValue(String fieldName, double value)
        {
            fieldList.add(fieldName);
            valueList.add("" + value);
        }
        
        public void addFloatValue(String fieldName, float value)
        {
            fieldList.add(fieldName);
            valueList.add("" + value);
        }

        public void addTimeValue(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("to_date('" + value + "','YYYY/MM/DD HH24:MI:SS')");
        }
        // for sqlite
        public void addDateValue(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("DATE('" + value + "')");
        }

        public void addPrepareTimeValue(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("to_date(" + value + ",'YYYY/MM/DD HH24:MI:SS')");
        }

        public void addSysdateValue(String fieldName)
        {
            fieldList.add(fieldName);
            valueList.add("DATETIME('now','localtime')");
        }

        public void addTimeStampValue(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("TO_TIMESTAMP('" + value + "','YYYY/MM/DD HH24:MI:SS.FF')");
        }

        public void addCCMSTimeStampValue(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("TO_TIMESTAMP('" + value + "','YYYYMMDDHH24MISSFF3')");
        }

        public void addSystimestampValue(String fieldName)
        {
            fieldList.add(fieldName);
            valueList.add("systimestamp");
        }

        public String toString()
        {
            StringBuffer sbRtn = new StringBuffer();//V1.0.5

            sbRtn.append(SQL.INSERT + tableName + SQL.SPACE + "(");

            for (int i = 0; i < fieldList.size(); i++)
            {
                sbRtn.append(fieldList.get(i).toString() + SQL.COMMA);
            }
            sbRtn.deleteCharAt(sbRtn.lastIndexOf(SQL.COMMA));
            sbRtn.append(")" + SQL.VALUES + "(");

            for (int i = 0; i < valueList.size(); i++)
            {
                sbRtn.append(valueList.get(i).toString() + SQL.COMMA);
            }
            sbRtn.deleteCharAt(sbRtn.lastIndexOf(SQL.COMMA));
            sbRtn.append(")");

            return sbRtn.toString();
        }
    }
    /*
     * V2.0.8
     * Remove condition properyies
     * Extends SQLcond
     */
    // Delete Class
    public static class SQLDeleter extends SQLCond
    {
        private String tableName;

        public SQLDeleter(String tableName)
        {
            this.tableName = tableName;
        }

        public void setTableName(String tableName)
        {
            this.tableName = tableName;
        }

        public String toString()
        {
            StringBuffer sbRtn = new StringBuffer();//V1.0.5

            sbRtn.append(SQL.DELETE + tableName + SQL.SPACE + SQL.WHERE);
            sbRtn.append(this.getCoditction());
            return sbRtn.toString();
        }


    }
    /*
     * V2.0.8
     * Add setTableName
     * Remove condition properties
     * Extends SQLcond
     * addStringCond - the same with addStrCond in SQLcond
     * addIntGreatCond - the same with addNumCondGreater
     * addIN_Cond -the same with  addInCond
     * getCoditction - get condition string
     */
    // Update Class
    public static class SQLUpdater extends SQLCond
    {
        private String tableName;
        private ArrayList<String> fieldList = new ArrayList<String>();
        private ArrayList<String> valueList = new ArrayList<String>();

        public SQLUpdater()
        {
        }

        public SQLUpdater(SQLSelecter selecter)
        {
            this.tableName = "(" + selecter.toString() + ")";
        }

        public SQLUpdater(String tableName)
        {
            this.tableName = tableName;
        }

        public void updateTable(String tableName)
        {
            this.tableName = tableName;
        }

        public void setTableName(String tableName)
        {
            this.tableName = tableName;
        }

        public void updateStrField(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add(SQL.QUOTE + value + SQL.QUOTE);
        }

        public void updateTimeField(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("DateTime('" + value + "','YYYY/MM/DD HH24:MI:SS')");
        }
        
        public void updateDateField(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("DATE('" + value + "')");
        }

        public void updateTimeField(String fieldName)
        {
            fieldList.add(fieldName);
            valueList.add("DATETIME('now','localtime')");
        }

        public void updateTimestampField(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("TO_TIMESTAMP('" + value + "','YYYY/MM/DD HH24:MI:SS.FF')");
        }

        public void updateCCMSTimestampField(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add("TO_TIMESTAMP('" + value + "','YYYYMMDDHH24MISSFF3')");
        }

        public void updateTimestampField(String fieldName)
        {
        	fieldList.add(fieldName);
            valueList.add("DATETIME('now','localtime')");
//            fieldList.add(fieldName);
//            valueList.add(SQL.SYSTIMESTAMP);
        }

        //V1.0.9
        public void updateLongField(String fieldName, long value)
        {
            fieldList.add(fieldName);
            valueList.add("" + value);
        }

        public void updateIntField(String fieldName, int value)
        {
            fieldList.add(fieldName);
            valueList.add("" + value);
        }

        public void updateIntField(String fieldName, String value)
        {
            fieldList.add(fieldName);
            valueList.add(value);
        }

        //V2.0.1
        public void updateDoubleValue(String fieldName, double value)
        {
            fieldList.add(fieldName);
            valueList.add("" + value);
        }

        public void updateNullField(String fieldName)
        {
            fieldList.add(fieldName);
            valueList.add(SQL.NULL);
        }

        public void addStringCond(String field, String value)
        {
            this.addStrCond(field, value);
            //condValueList.add(field + SQL.EQUAL + SQL.QUOTE + value + SQL.QUOTE);
        }

        //V1.2.3 Add Start
        public void addIntGreatCond(String field, int value)
        {
            this.addNumCondGreater(field, ""+value);
            //condValueList.add(field + SQL.GREATER + value);
        }

        //V1.2.1
        public void addIN_Cond(String field, String value)
        {
            this.addInCond(field, value);
            //condValueList.add(field + SQL.IN + "(" + value + ")");
        }

        public String toString()
        {
            StringBuffer sbRtn = new StringBuffer();

            // Specify table name
            sbRtn.append(SQL.UPDATE + tableName + SQL.SPACE + SQL.SET);

            // Specify the fields to be updated
            for (int i = 0; i < fieldList.size(); i++)
            {
                sbRtn.append(fieldList.get(i) + SQL.EQUAL + valueList.get(i) + SQL.COMMA);
            }
            // remove the trailing comma
            sbRtn.deleteCharAt(sbRtn.lastIndexOf(SQL.COMMA));

            // Specify the conditions
            sbRtn.append(SQL.SPACE + SQL.WHERE);
            sbRtn.append(this.getCoditction());
            return sbRtn.toString();
        }
    }

    //V1.0.8 Add Start
    // SQL Single Or Condition
    public static class SQLSingleOrCondition
    {
        private ArrayList<String> fieldNames;
        private ArrayList<String> fieldValues;

        public SQLSingleOrCondition()
        {
            fieldNames = new ArrayList<String>();
            fieldValues = new ArrayList<String>();
        }

        public SQLSingleOrCondition(ArrayList<String> fieldNames)
        {
            this.fieldNames = fieldNames;
        }

        public void setFieldName(String sFieldName, int iRepeatLen)
        {
            for (int iCnt = 0; iCnt < iRepeatLen; iCnt++)
            {
                fieldNames.add(sFieldName);
            }
        }

        public void setFieldName(String sFieldName)
        {
            fieldNames.add(sFieldName);
        }

        public void setFieldValue(String sFieldValue)
        {
            fieldValues.add(sFieldValue);
        }

        public void setValues(ArrayList<String> fieldValues)
        {
            this.fieldValues = fieldValues;
        }

        public String toString()
        {
            StringBuffer rtnValue = new StringBuffer();

            rtnValue.append("("); // V1.2.5

            for (int iFieldCnt = 0; iFieldCnt < fieldNames.size(); iFieldCnt++)
            {
                rtnValue.append(fieldNames.get(iFieldCnt)
                        + SQL.EQUAL
                        + SQL.QUOTE
                        + fieldValues.get(iFieldCnt)
                        + SQL.QUOTE);

                if (iFieldCnt < (fieldNames.size() - 1))
                {
                    rtnValue.append(SQL.OR);
                }
            }

            rtnValue.append(")"); // V1.2.5

            return rtnValue.toString();
        }
    }

    //V1.0.8 Add End

    // SQL Or Condition Class
    public static class SQLOrCondition
    {
        // currently this only support 2 fields
        private String fieldName1;
        private String fieldName2;
        private ArrayList<String> valueList1;
        private ArrayList<String> valueList2;

        public SQLOrCondition(String fieldName1, String fieldName2)
        {
            this.fieldName1 = fieldName1;
            this.fieldName2 = fieldName2;
        }

        public void setValues(ArrayList<String> valueList1, ArrayList<String> valueList2)
        {
            this.valueList1 = valueList1;
            this.valueList2 = valueList2;
        }

        public void setValues(String sValue1, String sValue2)
        {
            this.valueList1 = new ArrayList<String>();
            this.valueList2 = new ArrayList<String>();
            this.valueList1.add(sValue1);
            this.valueList2.add(sValue2);
        }

        public String toString()
        {
            StringBuffer rtnValue = new StringBuffer();

            rtnValue.append("(");
            for (int i = 0; i < valueList1.size(); i++)
            {
                rtnValue.append("(");

                rtnValue.append(fieldName1 + SQL.EQUAL + SQL.QUOTE + valueList1.get(i) + SQL.QUOTE);
                rtnValue.append(SQL.AND);
                rtnValue.append(fieldName2 + SQL.EQUAL + SQL.QUOTE + valueList2.get(i) + SQL.QUOTE);

                rtnValue.append(")");
                if (i < (valueList1.size() - 1))
                {
                    rtnValue.append(SQL.OR);
                }
            }
            rtnValue.append(")");

            return rtnValue.toString();
        }
    }

    // Clean up resources
    public void cleanupResource()
    {
        // clean up statement
        for (int i = 0; i < statementList.size(); i++)
        {
            if (!(statementList.get(i) instanceof Statement))
                continue;
            Statement stmt = (Statement) statementList.get(i);
            try
            {
                stmt.close();
            }
            catch (SQLException ignore)
            {
            }
        }
        statementList.clear();

        // clean up result set
        for (int i = 0; i < resultSetList.size(); i++)
        {
            if (!(resultSetList.get(i) instanceof ResultSet))
                continue;
            ResultSet rs = (ResultSet) resultSetList.get(i);
            try
            {
                rs.close();
            }
            catch (SQLException ignore)
            {
            }
        }
        resultSetList.clear();
    }

  

 
    // SQL Query Function by PreparedStatement
    public ResultSet Query_Func(PreparedStatement stmt, String str_SQL, String ErrCode)
            throws SQLException
    {
        ResultSet rs = null;
        try
        {
            statementRunCount++;
            rs = stmt.executeQuery();
            resultSetList.add(rs);
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }
        return rs;
    }

    //V1.0.2
    public void closeRS(ResultSet rs) throws SQLException
    {
        rs.close();
        rs = null;
    }


    public Date getDate(String date)
    {
        Date dateFormat = null;

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try
        {
            dateFormat = format.parse(date);
        }
        catch (ParseException ignore)
        {
            ignore.printStackTrace();
        }

        return dateFormat;
    }

     // Add Batch SQL
    protected void addBatch(Statement stmt, String sql) throws SQLException
    {
        sqlBatchCommands = sqlBatchCommands + sql + "\n";
        stmt.addBatch(sql);
    }

    // Execute Batch SQL
    protected void executBatch(Statement stmt, String ErrCode) throws SQLException
    {
        try
        {
            if (!sqlBatchCommands.equals(""))
            {
                statementRunCount++;
                stmt.executeBatch();
                stmt.clearBatch();
            }
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }
        finally
        {
            sqlBatchCommands = "";
        }
    }

    // Get statement list size
    protected int getStmtListSize()
    {
        return statementList.size();
    }

    // Get String Function
    public String getStr(Object o)
    {
        return o == null ? "" : o.toString().trim();
    }

    // Get Integer Function
    public int getInt(Object o)
    {
        try
        {
            return o == null ? 0 : Integer.parseInt(o.toString().trim());
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    // Get Integer Function
    public boolean getBoolean(Object o)
    {
        try
        {
            return o == null ? false : o.toString().trim().equalsIgnoreCase("Y");
        }
        catch (Exception e)
        {
            return false;
        }
    }

    // Get Float Function
    public float getFloat(Object o)
    {
        try
        {
            return o == null ? 0 : Float.parseFloat(o.toString().trim());
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    // Get Double Function
    public double getDouble(Object o)
    {
        try
        {
            return o == null ? 0 : Double.parseDouble(o.toString().trim());
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    // Get DB connection
    protected Connection getConnection()
    {
        return dbConnection;
    }

    // Get DB Statement
    public Statement getStatement() throws SQLException
    {
        Statement stmt = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);
        statementList.add(stmt);
        return stmt;
    }

    // Get DB PreparedStatement
    public PreparedStatement getPreparedStatement(String sSQL) throws SQLException
    {
        PreparedStatement stmt = dbConnection.prepareStatement(sSQL);
        statementList.add(stmt);
        return stmt;
    }

    // Change datetime format
    protected static String changeDT(Date datetime)
    {
    	return changeDT(datetime, "yyyy-MM-dd HH:mm:ss");
    }
    
    protected static String changeDT(Date datetime, String strFormat)
    {
        String rtnString = "";
        if (datetime != null)
        {
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat(strFormat);
            rtnString = formatter.format(datetime);
        }
        return rtnString;

    }

 

    // Store fail operation if needed
    protected void storeFailOperation() throws SQLException, Exception
    {
        // overwrite if needed
    }

    // Print out debug exception
    protected void printDebugException(Throwable exception)
    {
        System.out.println(exception.getMessage());
        exception.printStackTrace(System.out);
    }

    //======================================
    // Interface
    //======================================

    // SQL Command Element
    public static interface SQL
    {
        final public String UPDATE = "Update ";
        final public String SELECT = "Select ";
        final public String DELETE = "DELETE FROM ";
        final public String INSERT = "INSERT INTO ";
        final public String FROM = " FROM ";
        final public String WHERE = " Where ";
        final public String VALUES = " VALUES ";
        final public String ORDER_BY = " Order By ";
        final public String GROUP_BY = " Group By ";
        final public String DESC = " DESC";
        final public String AND = " And ";
        final public String OR = " Or ";
        final public String IN = " In ";
        final public String LIKE = " Like ";        
        final public String SET = "SET ";
        final public String SPACE = " ";
        final public String EQUAL = " = ";
        final public String GREATER = " > ";
        final public String LESS = " < ";
        final public String NOT_EQUAL = " <> ";
        final public String GREATEREQUAL = ">=";
        final public String LESSEQUAL = "<=";
        final public String BETWEEN = " between ";
        final public String COMMA = ", ";
        final public String QUOTE = "'";
        final public String SYSDATE = "sysdate";
        final public String SYSTIMESTAMP = "systimestamp";
        final public String NULL = "null";
        final public String MAX = "MAX";//V1.2.2
        final public String MIN = "MIN";//V1.2.2
        final public String L_PARENTHESIS = "(";//V1.2.2
        final public String R_PARENTHESIS = ")";//V1.2.2
        final public String SUM = "SUM";//V1.2.6
        final public String ISNULL = " is ";//V2.0.0
        final public String ISNOTNULL = " is not ";//V2.0.0
        final public String Distinct = "distinct ";//V2.0.5
    }
 
}