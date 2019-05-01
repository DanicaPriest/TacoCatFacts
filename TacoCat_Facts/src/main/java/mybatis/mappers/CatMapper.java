package mybatis.mappers;

import mybatis.model.CatFacts.CatRoot;
import mybatis.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CatMapper {

    String INSERT_CATFACTS = "INSERT INTO `mybatis-test`.cat_facts (fact, length) " +
            "VALUES (#{fact}, #{length})";
    String GET_CATFACT = "SELECT * FROM `mybatis-test`.cat_facts where fact = #{fact}";
    String GET_BY_ID = "SELECT * FROM `mybatis-test`.cat_facts where id = #{id}";
    String GET_USER = "SELECT * FROM `mybatis-test`.user_verify where user = #{user}";
    String UPDATE_CATFACT = "UPDATE `mybatis-test`.cat_facts SET cat_fact = #{fact} WHERE id = #{id}";
    String DELETE_CATFACT = "DELETE FROM `mybatis-test`.cat_facts  WHERE id = #{id}";


    @Insert(INSERT_CATFACTS)
    public int insertCatFacts(CatRoot fact);

    @Select(GET_CATFACT)
    public CatRoot getCF(String fact);

    @Select(GET_BY_ID)
    public CatRoot getCFById(int id);

    @Update(UPDATE_CATFACT)
    public int updateCF(CatRoot fact);

    @Delete(DELETE_CATFACT)
    public int deleteCF(CatRoot fact);

    @Select(GET_USER)
    public User getUser(String user);

}
