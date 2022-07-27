package du.reply.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import du.reply.dao.ReplyDAO;
import du.reply.domain.ReplyVO;
import du.reply.service.ReplyService;
import du.user.domain.UserVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public void insertReply(HttpSession session, ReplyVO reply) {
		
		UserVO user=(UserVO)session.getAttribute("USER");
		
		if(user != null) {
			reply.setWriterId(user.getUserId());
			
			replyDAO.insertReply(reply);
			
		}
		
	
		
	}

	@Override
	public List<ReplyVO> selectReplyList(long boardIdx) {
		
		return replyDAO.selectReplyList(boardIdx);
	}

	@Override
	public void deleteReply(long idx) {
		
		replyDAO.deleteReply(idx);
		
	}

	@Override
	public void updateReply(ReplyVO reply) {
		
		replyDAO.updateReply(reply);
		
	}
	
}
