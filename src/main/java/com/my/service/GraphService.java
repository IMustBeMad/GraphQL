package com.my.service;

import java.util.Map;

public interface GraphService {

    Map<String,Object> processQuery(Map<String, Object> request);
}
