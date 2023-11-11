package da_bangiay.Service;

import da_bangiay.Model.KhachHang;
import da_bangiay.Repository.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangService {

    String sql = null;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public List<KhachHang> getAll() {
        sql = "SELECT id, Name, SĐTKhachHang, GioiTinh, Email, Create_by, Update_by, Create_at, Update_at FROM tbl_KhachHang";
        List<KhachHang> listkh = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDate(8), rs.getDate(9));
                listkh.add(kh);
            }
            return listkh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getKH(int id) {
        sql = "SELECT id, Name, SĐTKhachHang, GioiTinh, Email, Create_by, Update_by, Create_at, Update_at FROM tbl_KhachHang WHERE id = ?";
        KhachHang kh = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDate(8), rs.getDate(9));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insert(KhachHang kh) {
        sql = "INSERT INTO dbo.tbl_KhachHang(id, Name, SĐTKhachHang, GioiTinh, Email, Create_by, Update_by, Create_at, Update_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getId());
            ps.setObject(2, kh.getName());
            ps.setObject(3, kh.getPhone());
            ps.setObject(4, kh.getGender());
            ps.setObject(5, kh.getEmail());
            ps.setObject(6, kh.getCreateBy());
            ps.setObject(7, kh.getUpdateBy());
            ps.setObject(8, kh.getCreateAt());
            ps.setObject(9, kh.getUpdateAt());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(KhachHang kh, int id) {
        sql = "UPDATE tbl_KhachHang SET Name = ?, SĐTKhachHang = ?, GioiTinh = ?, Email = ?, Create_by = ?, Update_by = ?, Create_at = ?, Update_at = ? WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getName());
            ps.setObject(2, kh.getPhone());
            ps.setObject(3, kh.getGender());
            ps.setObject(4, kh.getEmail());
            ps.setObject(5, kh.getCreateBy());
            ps.setObject(6, kh.getUpdateBy());
            ps.setObject(7, kh.getCreateAt());
            ps.setObject(8, kh.getUpdateAt());
            ps.setObject(9, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int id) {
        sql = "DELETE FROM tbl_KhachHang WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
