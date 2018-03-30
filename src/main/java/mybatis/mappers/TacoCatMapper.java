package mybatis.mappers;

import mybatis.model.CatFacts.OnlyFacts;
import mybatis.model.TacoCat.TacoRoot;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TacoCatMapper {

    String INSERT_TACOCATFACTS = "INSERT INTO `mybatis-test`.tacocat_facts (name, recipe, url, cat_fact) " +
            "VALUES (#{cat_fact})";
    String GET_TACOCATFACT = "SELECT * FROM `mybatis-test`.tacocat_facts where cat_fact = #{cat_fact}";
    String GET_BY_ID = "SELECT * FROM `mybatis-test`.tacocat_facts where id = #{id}";
    String DELETE_CATFACT = "DELETE FROM `mybatis-test`.tacocat_facts  WHERE id = #{id}";

    @Insert(INSERT_TACOCATFACTS)
    public TacoRoot insertTacocatFacts(TacoRoot tacoRoot);

    @Select(GET_TACOCATFACT)
    public TacoRoot getTCF(String fact);

    @Select(GET_BY_ID)
    public TacoRoot getCFById(int id);


    @Delete(DELETE_CATFACT)
    public int deleteCF(TacoRoot fact);
}
