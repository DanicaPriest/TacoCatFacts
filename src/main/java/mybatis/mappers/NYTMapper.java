package mybatis.mappers;

import mybatis.model.nyt.NYTDocs;
import mybatis.model.nyt.internal.NYTOverview;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NYTMapper {


    String INSERT_SUMMARY = ("INSERT INTO `mybatis-test`.`nyt_summary` (`headline`, `imageUrl`, `summary`, `date`) " +
            "VALUES (#{headline}, #{imageUrl}, #{summary}, #{date})");

    @Insert(INSERT_SUMMARY)
    public int insertSummary(NYTOverview result);

}

