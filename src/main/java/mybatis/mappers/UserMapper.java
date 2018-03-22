package mybatis.mappers;

import mybatis.model.User;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

@Mapper
public interface UserMapper {

    String GET_ALL__ACTIVE_USERS = "SELECT * FROM `mybatis-test`.Users where isActive = 1";
    String GET_BY_ID = "SELECT * FROM `mybatis-test`.Users where id = #{id}";
    String INSERT_USER = "INSERT INTO `mybatis-test`.Users (first_name, last_name, isActive) " +
            "VALUES (#{first_name}, #{last_name}, #{isActive})";
    String UPDATE_USER = "UPDATE `mybatis-test`.Users SET first_name = #{first_name}, " +
            "last_name = #{last_name}, isActive = #{isActive} WHERE id = #{id}";
    String DELETE_USER = "UPDATE `mybatis-test`.Users set isActive = 0 WHERE id = #{id}";
    String GET_BY_NAME = "SELECT * FROM `mybatis-test`.Users where first_name = #{first_name}";

    @Select(GET_BY_NAME)
    public User getByName(String name);

    @Select(GET_ALL__ACTIVE_USERS)
    public ArrayList<User> getAllUsers();

    @Select(GET_BY_ID)
    public User getByID(int id);

    @Insert(INSERT_USER)
    public int insertUser (User user);

    @Update(UPDATE_USER)
    public int updateUser (User user);

    @Delete(DELETE_USER)
    public int deleteUser(int id);

}