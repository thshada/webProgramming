package du.dept.dao;

import java.util.List;

import du.dept.domain.DeptVO;

public interface DeptDAO {
	public List<DeptVO> selectDeptList();
	public void insertDept(DeptVO dept);
	public void deleteDept(String deptCd);
	
	
	
	
}
