package com.yjyq.user.conf;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UreportTestBean {
    public List<Map<String,Object>> loadReportData(String dsName,String datasetName,Map<String,Object> parameters){
        return null;
    }
    public List<Map<String,Object>> buildReport(String dsName, String datasetName, Map<String,Object> parameters){
        return null;
    }
}
