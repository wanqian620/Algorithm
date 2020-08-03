package com.example.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: wanqian
 * @Date: 2020/4/17 11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmartMonitorHostDTO {

    /**
     * 设备ID
     */
    private Integer id;
    /**
     * 设备别名
     */
    private String alias;
    /**
     * 设备IP
     */
    private String ip;
    /**
     * 代理端口
     */
    private Integer agentPort;
    /**
     * 主机名
     */
    private String hostName;
    /**
     * 代理状态
     */
    private String agentState;
    /**
     * 设备状态
     */
    private String state;
    /**
     * 最近一条CPU负载
     */
    private Double cpuLoad;

    /**
     * 是否开启智能监控
     */
    private boolean isSmartMonitor;

    /**
     * 易云系统id
     */
    private Integer ecloudId;


}
