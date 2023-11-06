package service;

import java.util.List;

import model.baiviet;
import model.nguoidung;
import modelMapper.BaiVietMapper;

public class BaivietService extends DAOService<baiviet> {
	
	public List<baiviet> getFriendsBaiViet(nguoidung currentUser){
		String sql = "SELECT b.*\r\n"
				+ "FROM baiviet b\r\n"
				+ "INNER JOIN thongtinketban t ON (b.MaNguoiDung = t.MaNguoiDung1 OR b.MaNguoiDung = t.MaNguoiDung2)\r\n"
				+ "WHERE (t.MaNguoiDung1 = ? OR t.MaNguoiDung2 = ?) AND t.TrangThai = 'daketban'";
		return query(sql, new BaiVietMapper(), currentUser.getMaNguoiDung(), currentUser.getMaNguoiDung());
	}
}
