package com.thinkbiganalytics.datalake.authorization.model;

/*-
 * #%L
 * thinkbig-hadoop-authorization-core
 * %%
 * Copyright (C) 2017 ThinkBig Analytics
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * SearchPolicy class for setting search parameters and returns search query object
 *
 */
public class SearchPolicy {

    private Integer pageSize;
    private Integer startIndex;
    private String policyName;
    private List<String> columns;
    private List<String> columnFamilies;
    private List<String> tables;
    private List<String> udfs;
    private List<String> databases;
    private String groupName;
    private String repositoryType;
    private Boolean isRecursive;
    private String repositoryName;
    private String username;
    private Boolean isEnabled;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<String> getColumnFamilies() {
        return columnFamilies;
    }

    public void setColumnFamilies(List<String> columnFamilies) {
        this.columnFamilies = columnFamilies;
    }

    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }

    public List<String> getUdfs() {
        return udfs;
    }

    public void setUdfs(List<String> udfs) {
        this.udfs = udfs;
    }

    public List<String> getDatabases() {
        return databases;
    }

    public void setDatabases(List<String> databases) {
        this.databases = databases;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(String repositoryType) {
        this.repositoryType = repositoryType;
    }

    public Boolean isRecursive() {
        return isRecursive;
    }

    public void setRecursive(Boolean recursive) {
        isRecursive = recursive;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    /***
     * SearchCriteria function for building search query with passed passed search parameters
     *
     * @return Map object with search parameters
     */

    public Map<String, Object> searchCriteria()

    {
        Map<String, Object> searchParams = new HashMap<>();
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<String> columnFamilies = new ArrayList<String>();
        ArrayList<String> tables = new ArrayList<String>();
        ArrayList<String> udfs = new ArrayList<String>();

        //Add columns to list
        if (columns.isEmpty()) {
            //Do not add anything to list
        } else {
            for (int colCnt = 0; colCnt < columns.size(); colCnt++) {
                columns.add(getColumns().get(colCnt));
            }
            searchParams.put("columns", columns);
        }

        //Add columnfamilies to list
        if (columnFamilies.isEmpty()) {
            //Do not add anything to list
        } else {
            for (int colFamilyCnt = 0; colFamilyCnt < getColumnFamilies().size(); colFamilyCnt++) {
                columnFamilies.add(getColumnFamilies().get(colFamilyCnt));
            }
            searchParams.put("columnFamilies", columnFamilies);
        }

        //Add tables
        if (tables.isEmpty()) {
            //Do not add anything to list
        } else {
            for (int tableCnt = 0; tableCnt < getTables().size(); tableCnt++) {
                tables.add(getTables().get(tableCnt));
            }
            searchParams.put("tables", tables);
        }

        //Add udf names to list
        if (udfs.isEmpty()) {

        } else {
            for (int udfCnt = 0; udfCnt < getUdfs().size(); udfCnt++) {
                tables.add(getUdfs().get(udfCnt));
            }
            searchParams.put("udfs", udfs);
        }

        searchParams.put("pageSize", getPageSize());
        searchParams.put("startIndex", getStartIndex());
        searchParams.put("policyName", getPolicyName());
        searchParams.put("groupName", getGroupName());
        searchParams.put("repositoryType", getRepositoryType());
        searchParams.put("isRecursive", isRecursive());
        searchParams.put("repositoryName", getRepositoryName());
        searchParams.put("userName", getUsername());
        searchParams.put("isEnabled", isEnabled());

        return searchParams;
    }
}
