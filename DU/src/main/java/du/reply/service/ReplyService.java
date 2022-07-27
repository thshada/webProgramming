package du.reply.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import du.reply.domain.ReplyVO;

public interface ReplyService {
	
	public void insertReply(HttpSession session,ReplyVO reply);
	
	public List<ReplyVO> selectReplyList(long boardIdx);
	
	
	public void deleteReply(long idx);
	
	public void updateReply(ReplyVO reply);
}
