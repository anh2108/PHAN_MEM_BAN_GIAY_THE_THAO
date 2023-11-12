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
        sql = "SELECT KhachHang.id as KHID, HoTen, SoDt, GioiTinh, Email, KhachHang.NgayTao, KhachHang.NgaySua, ThanhPho FROM KhachHang JOIN DiaChi ON DiaChi.id = KhachHang.id_DiaChi";
        List<KhachHang> listkh = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
//                System.out.println("id = " + rs.getString("KHID")); làm như này
                KhachHang kh = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getString(8));
                listkh.add(kh);
            }
            return listkh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getKH(int id) {
        sql = "SELECT KhachHang.id, HoTen, SoDt, GioiTinh, Email, ThanhPho, KhachHang.NgayTao, KhachHang.NgaySua FROM KhachHang JOIN DiaChi ON DiaChi.id = KhachHang.id_DiaChi WHERE KhachHang.id = ?";
        KhachHang kh = null;
        try {
            con = DBConnect.getConnection(); 
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getString(8));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insert(KhachHang kh) {
        sql = "INSERT INTO KhachHang(HoTen, GioiTinh, SoDt, Email, NguoiTao, NguoiSua, NgayTao, NgaySua, id_DiaChi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getName());
            ps.setObject(2, kh.isGender());
            ps.setObject(3, kh.getPhone());
            ps.setObject(4, kh.getEmail());
            ps.setObject(5, kh.getCreateBy());
            ps.setObject(6, kh.getUpdateBy());
            ps.setObject(7, kh.getCreateAt());
            ps.setObject(8, kh.getUpdateAt());
            ps.setObject(9, kh.getIdDC());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(KhachHang kh, int id) {
        sql = "UPDATE KhachHang SET HoTen = ?, GioiTinh = ?, SoDt = ?, Email = ?, NguoiTao = ?, NguoiSua = ?, NgayTao = ?, NgaySua = ? WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getName());
            ps.setObject(2, kh.isGender());
            ps.setObject(3, kh.getPhone());
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
        sql = "DELETE FROM KhachHang WHERE id = ?";
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
