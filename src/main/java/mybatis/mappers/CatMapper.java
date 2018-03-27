package mybatis.mappers;


import mybatis.model.CatFacts.All;
import mybatis.model.CatFacts.OnlyFacts;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CatMapper {

    String INSERT_CATFACTS = "INSERT INTO `mybatis-test`.cat_facts (cat_fact) " +
            "VALUES (#{cat_fact})";
    String GET_CATFACT = "SELECT * FROM `mybatis-test`.cat_facts where cat_fact = #{cat_fact}";
    String GET_BY_ID = "SELECT * FROM `mybatis-test`.cat_facts where id = #{id}";
    String UPDATE_CATFACT = "UPDATE `mybatis-test`.cat_facts SET cat_fact = #{cat_fact} WHERE id = #{id}";
    String DELETE_CATFACT = "DELETE `mybatis-test`.cat_facts  WHERE id = #{id}";


    @Insert(INSERT_CATFACTS)
    public int insertCatFacts(OnlyFacts facts);

    @Select(GET_CATFACT)
    public OnlyFacts getCF(String fact);

    @Select(GET_BY_ID)
    public OnlyFacts getCFById(int id);

    @Update(UPDATE_CATFACT)
    public int updateCF(int id);

    @Delete(DELETE_CATFACT)
    public int deleteCF(int id);

}
