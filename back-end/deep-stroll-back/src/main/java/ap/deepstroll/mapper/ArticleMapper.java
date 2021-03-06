package ap.deepstroll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ap.deepstroll.entity.ArticleEntity;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleMapper {
    
    /**
     * 插入一条新的文章
     * @author mxf
     * @param articleEntity
     */
    public Integer insertArticle(ArticleEntity articleEntity);

    public Integer realDelete(@Param("id")Long id);

    /**
     * 查询指定id的文章信息
     * @author
     * @param id
     * @return
     */
    public ArticleEntity queryArticleById(@Param("id")Long id);

    /**
     * 查询指定作者的作品
     * @param id
     * @return
     */
    public List<ArticleEntity> queryArticleByAuthorId(
        @Param("authorId")Long id,
        @Param("title")String title,
        @Param("label")String label,
        @Param("classifyId")Integer classifyId,
        @Param("state")Integer state,
        @Param("startIndex")Integer startIndex,
        @Param("pageSize")Integer pageSize
    );

    public Integer queryArticleNumByAuthorId(
        @Param("authorId")Long id,
        @Param("title")String title,
        @Param("label")String label,
        @Param("classifyId")Integer classifyId,
        @Param("state")Integer state
    );

    /**
     * 根据限定条件搜索文章
     * @author mxf
     * @param title
     * @param label
     * @param classifyId
     * @param state
     * @param startIndex notnull
     * @param pageSize notnull
     * @return
     */
    public List<ArticleEntity> queryArticleByTitleLabClassifyState(
        @Param("title")String title,
        @Param("label")String label,
        @Param("classifyId")Integer classifyId,
        @Param("state")Integer state,
        @Param("startIndex")Integer startIndex,
        @Param("pageSize")Integer pageSize,
        @Param("likeNum")Integer likeNum
    );

    /**
     * 返回符合条件的总数
     * @author mxf
     * @param title
     * @param label
     * @param classifyId
     * @param state
     * @param likeNum
     * @return
     */
    public Integer queryArticleNumByTitleLabClassifyState(
        @Param("title")String title,
        @Param("label")String label,
        @Param("classifyId")Integer classifyId,
        @Param("state")Integer state,
        @Param("likeNum")Integer likeNum
    );

    /**
     * 更新文章状态
     * @author mxf
     * @param id
     * @param state
     */
    public Integer updateArticleState(@Param("id")Long id, @Param("state")Integer state);

    /**
     * 增加点赞数1
     * @author mxf
     * @param id
     * @return
     */
    public Integer updateLikeNumById(@Param("id")Long id, @Param("num")Integer num);

}
