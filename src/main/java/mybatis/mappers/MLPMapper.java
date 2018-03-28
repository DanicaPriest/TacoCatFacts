package mybatis.mappers;

import mybatis.model.MLP.MLPOverview;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MLPMapper {

    String INSERT_MLP = "INSERT INTO `mybatis-test`.mlp (created_at, tags, uploader, image, width, height) " +
            "VALUES (#{created_at}, #{tags}, #{uploader}, #{image}, #{width}, #{height})";
    String GET_BY_ID = "SELECT * FROM `mybatis-test`.mlp where id = #{id}";
    String MAKE_ACTIVE = "UPDATE `mybatis-test`.mlp SET isActive = 1 WHERE id = #{id}";
    String DELETE_MLP = "UPDATE `mybatis-test`.mlp  SET isActive = 0 WHERE id = #{id}";


    @Insert(INSERT_MLP)
    public int insertMLP(MLPOverview result);

    @Select(GET_BY_ID)
    public MLPOverview getMLP(int id);

    @Update(MAKE_ACTIVE)
    public int makeActive(MLPOverview result);

    @Delete(DELETE_MLP)
    public int deleteMLP(MLPOverview result);

}