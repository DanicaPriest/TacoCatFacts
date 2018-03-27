package mybatis.mappers;


import mybatis.model.CatFacts.CatFactsOverview;
import mybatis.model.CatFacts.OnlyFacts;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CatMapper {

    String INSERT_CATFACTS = "INSERT INTO `mybatis-test`.cat_facts (cat_fact) " +
            "VALUES (#{cat_fact})";


    @Insert(INSERT_CATFACTS)
    public int insertCatFacts(OnlyFacts facts);


}
