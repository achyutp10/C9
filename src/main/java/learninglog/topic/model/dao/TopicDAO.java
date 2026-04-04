package learninglog.topic.model.dao;

import learninglog.topic.model.Topic;
import learninglog.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TopicDAO implements TopicInterface {
    @Override
    public boolean insertTopic(Topic topic) {
        if (topic.getName() == null || topic.getName().trim().isEmpty()) {
            return false;
        }

        String sql = "INSERT into topic(name,user_id,created_at,updated_at) values(?,?,NOW(),NOW())";

        try (Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, topic.getName());
            ps.setInt(2, topic.getUser_id());
            int row = ps.executeUpdate();
            return row > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
