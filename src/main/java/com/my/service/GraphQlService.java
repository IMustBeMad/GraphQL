package com.my.service;

import java.util.Map;

public interface GraphQlService {

    Map<String,Object> processQuery(String query);
}
