package learninglog.topic.model.dao;

import learninglog.topic.model.Topic;

public class TopicDAO implements TopicInterface {
    @Override
    public boolean insertTopic(Topic topic) {
        if (topic.getName() == null || topic.getName().trim().isEmpty()) {
            return false;
        }

        String sql = "INSERT into topic(name,user_id,created_at,updated_at) values(?,?,NOW(),NOW())";

    }
}
