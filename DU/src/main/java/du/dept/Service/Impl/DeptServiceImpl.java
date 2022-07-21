package du.dept.Service.Impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import du.dept.Service.DeptService;
import du.dept.dao.DeptDAO;
import du.dept.domain.DeptVO;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDAO deptDAO;

	@Override
	public List<DeptVO> selectDeptList() {
		return deptDAO.selectDeptList();
	}

	@Override
	public void insertDept(DeptVO dept) {
		deptDAO.insertDept(dept);
	}

	@Override
	public void deleteDept(String deptCd) {
		deptDAO.deleteDept(deptCd);
	}
	
	
	 
}
