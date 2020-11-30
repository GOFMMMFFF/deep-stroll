package ap.deepstroll.service;

import ap.deepstroll.entity.ClassifyArticleEntity;
import ap.deepstroll.entity.UserEntity;
import ap.deepstroll.entity.Work;
import ap.deepstroll.mapper.ArticleMapper;
import ap.deepstroll.mapper.ClassifyArticleMapper;
import ap.deepstroll.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ap.deepstroll.bo.Result;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ap.deepstroll.entity.ArticleEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("articleService")
@Primary
public class ArticleService extends WorkService{
    Integer pageSize = 10;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ClassifyArticleMapper classifyArticleMapper;

    @Override
    public Map<String,Object> browseWork(){
        HashMap<String,Object> response = new HashMap<>();
        HashMap<String,Object> data = new HashMap<>();
        try {
            List<ArticleEntity> articleList =  articleMapper.queryArticleByTitleLabClassifyState(null,null,null,0,null,null,null);
            data.put("article",articleList);
            Result result = new Result();
            Integer totalPage= articleMapper.queryArticleNumByTitleLabClassifyState(null,null,null,0,null)/this.pageSize + 1;
            data.put("totalpage",totalPage);
            response.put("result",result);
            response.put("data",data);
        }catch (Exception e){
            Result result = new Result(e.getMessage());
            response.put("data",null);
            response.put("result",result);
        }
        return response;
    }

    @Override
    /***
     * lqy
     * 分类浏览用户分享的作品:hao多参数
     */
    public Map<String,Object> searchWork(String title,String label,Integer classifyId,Integer state,Integer likeNum,Integer page) {
        Integer startIndex= this.pageSize * (page -1);
        HashMap<String,Object> response = new HashMap<>();
        HashMap<String,Object> data = new HashMap<>();
        try {
            List<ArticleEntity> articleList =  articleMapper.queryArticleByTitleLabClassifyState(title,label,classifyId,state,startIndex,this.pageSize,likeNum);
            data.put("article",articleList);
            Result result = new Result();
            Integer totalPage= articleMapper.queryArticleNumByTitleLabClassifyState(title,label,classifyId,state,likeNum)/this.pageSize + 1;
            data.put("totalpage",totalPage);
            response.put("result",result);
            response.put("data",data);
        }catch (Exception e){
            Result result = new Result(e.getMessage());
            response.put("data",null);
            response.put("result",result);
        }
        return response;
    }

    /***
     *我的作品
     */
    public Map<String ,Object> myWorks(Long aurhorId,String title,String label,Integer classify,Integer page){
        Integer startIndex= this.pageSize * (page -1);
        HashMap<String,Object> response = new HashMap<>();
        HashMap<String,Object> data = new HashMap<>();
        try {
            List<ArticleEntity> articleList =  articleMapper.queryArticleByAuthorId(aurhorId,title,label,classify,0,startIndex,pageSize);
            data.put("articles",articleList);
            Result result = new Result();
            Integer totalPage= articleMapper.queryArticleNumByAuthorId(aurhorId,title,label,classify,0)/this.pageSize+1;
            data.put("totalpage",totalPage);
            response.put("result",result);
            response.put("data",data);
        }catch (Exception e){
            Result result = new Result(e.getMessage());
            response.put("data",null);
            response.put("result",result);
        }
        return response;
    }

    /***
     * lqy
     * 获取作品的分类
     * @return
     */
    @Override
    public Map<String,Object> getClassify(){
        HashMap<String,Object> response = new HashMap<>();
        HashMap<String,Object> data = new HashMap<>();
        try{
            List<ClassifyArticleEntity> classifyArticleEntities= classifyArticleMapper.queryAllClassifyArticle(0);
            data.put("classify",classifyArticleEntities);
            response.put("data",data);
            response.put("result",new Result());
        }catch (Exception e){
            response.put("result",new Result(e.getMessage()));
        }
        return response;
    }

    /***
     * lqy
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getDetail(Long id) {
        HashMap<String,Object> response = new HashMap<>();
        HashMap<String,Object> data = new HashMap<>();
        try {
            ArticleEntity articleDetial = articleMapper.queryArticleById(id);
            Long authorId = articleDetial.getAuthorId();
            UserEntity userInfo = userMapper.queryUserById(authorId);
            HashMap<String,Object> author = new HashMap<>();
            author.put("id",userInfo.getId());
            author.put("nickname",userInfo.getNickname());
            author.put("avatar",userInfo.getAvatar());
            Result result = new Result();
            data.put("author",author);
            data.put("",userInfo);
            response.put("result",result);
            response.put("data",data);
        }catch (Exception e){
            Result result = new Result(e.getMessage());
            response.put("data",null);
            response.put("result",result);
        }
        return response;
    }

    /***
     * 发布
     * @param articleEntity
     * @return
     */
    public Result Publish(ArticleEntity articleEntity) {
        try{
            articleMapper.insertArticle(articleEntity);
            Result result = new Result();
            return result;
        }catch (Exception e){
            Result result = new Result(e.getMessage());
            return result;
        }
    }

    public Result Collection(Map<String,String> req){
        return null;
    }

    public Result deleteWork(Long id) {
        try{
            articleMapper.updateArticleState(id,1);
            Result result = new Result();
            return result;
        }catch (Exception e){
            Result result = new Result(e.getMessage());
            return result;
        }
    }

}
