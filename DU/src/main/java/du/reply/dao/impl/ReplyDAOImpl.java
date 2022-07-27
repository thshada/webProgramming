package du.reply.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import du.reply.dao.ReplyDAO;
import du.reply.domain.ReplyVO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class ReplyDAOImpl extends EgovAbstractMapper implements ReplyDAO {

	@Override
	public void insertReply(ReplyVO reply) {
		
		insert("Reply.insertReply",reply);
		
	}

	@Override
	public List<ReplyVO> selectReplyList(long boardIdx) {
		
		
		return selectList("Reply.selectReplyList",boardIdx);
	}

	@Override
	public void deleteReply(long idx) {
		
		delete("Reply.deleteReply",idx);
	}

	@Override
	public void updateReply(ReplyVO reply) {
		update("Reply.updateReply",reply);
	}
	

}
