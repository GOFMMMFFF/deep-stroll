package ap.deepstroll.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ap.deepstroll.entity.LogEntity;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LogMapper {
    
    /**
     * 插入一条log
     * @author mxf
     * @param logEntity
     * @return
     */
    public Integer insertLog(LogEntity logEntity);

    /**
     * 查询指定页的log
     * @author mxf
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<LogEntity> queryLog(
        @Param("startIndex")Integer startIndex,
        @Param("pageSize")Integer pageSize
    );

    public Integer queryLogNum();

    /**
     * 根据条件查询log
     * @author mxf
     * @param adminId
     * @param type
     * @param tableName
     * @param startTime
     * @param endTime
     * @return
     */
    public List<LogEntity> queryLogByAdminIdTypeTableNameTime(
        @Param("adminId")Integer adminId,
        @Param("type")Integer type,
        @Param("tableName")String tableName,
        @Param("startTime")Timestamp startTime,
        @Param("endTime")Timestamp endTime,
        @Param("startIndex")Integer startIndex,
        @Param("pageSize")Integer pageSize
    );

}
