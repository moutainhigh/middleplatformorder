package com.ly.traffic.middleplatform.domain.order.repository.mapper;

import com.ly.traffic.middleplatform.domain.order.repository.po.OrderEventSnapshotPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单事件快照记录表(OrderEventSnapshot)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-11 11:08:52
 */
public interface OrderEventSnapshotMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderEventSnapshotPO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderEventSnapshotPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderEventSnapshot 实例对象
     * @return 对象列表
     */
    List<OrderEventSnapshotPO> queryAll(OrderEventSnapshotPO orderEventSnapshot);

    /**
     * 新增数据
     *
     * @param orderEventSnapshot 实例对象
     * @return 影响行数
     */
    int insert(OrderEventSnapshotPO orderEventSnapshot);

    /**
     * 修改数据
     *
     * @param orderEventSnapshot 实例对象
     * @return 影响行数
     */
    int update(OrderEventSnapshotPO orderEventSnapshot);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
