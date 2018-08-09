package cc.nefuer.market.core.mapper.provider;

import cc.nefuer.market.core.model.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author jimi花
 * @dare 2018/7/26
 */
public class UserProvider {
    public String selectByCondition(User user) {
        return new SQL() {
            {
                SELECT("user_id AS userId, wechat_name AS wechatName, name," +
                        "profile_img AS profileImg, gender, tel_number AS telNumber, address, " +
                        "open_id AS openId,session_key AS sessionKey," +
                        "create_time AS createTime,last_edit_time AS lastEditTime");
                FROM("tb_user");
                if (null != user.getUserId()) {
                    WHERE("user_id=#{userId}");
                }
                if (null != user.getOpenId()) {
                    WHERE("open_id=#{openId}");
                }
            }
        }.toString();
    }

    public String updateByUserId(User user) {
        return new SQL() {
            {
                UPDATE("tb_user");
                if (null != user.getWechatName()) {
                    SET("wechat_name=#{wechatName}");
                }
                if (null != user.getName()) {
                    SET("name=#{name}");
                }
                if (null != user.getAddress()) {
                    SET("address=#{address}");
                }
                if (null != user.getTelNumber()) {
                    SET("tel_number=#{telNumber}");
                }
                WHERE("user_id=#{userId}");

            }
        }.toString();
    }
}
