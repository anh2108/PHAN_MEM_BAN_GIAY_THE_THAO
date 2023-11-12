package da_bangiay.Service;

import da_bangiay.Model.DiaChi;
import da_bangiay.Repository.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiaChiService {

    String sql = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection con = null;

    public List<DiaChi> getAll() {
        sql = "SELECT id, Duong, Tinh, ThanhPho, NguoiTao, NguoiSua, NgayTao, NgaySua FROM DiaChi";
        List<DiaChi> listdc = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DiaChi dc = new DiaChi(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDate(8), rs.getDate(9));
                listdc.add(dc);
            }
            return listdc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DiaChi getDC(int id) {
        sql = "SELECT DiaChi.id, Duong, Tinh, ThanhPho, DiaChi.NguoiTao, DiaChi.NguoiSua, DiaChi.NgayTao, DiaChi.NgaySua FROM DiaChi JOIN KhachHang ON KhachHang.id_DiaChi = DiaChi.id WHERE DiaChi.id = ?";
        DiaChi dc = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                dc = new DiaChi(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDate(8), rs.getDate(9));
            }
            return dc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insert(DiaChi dc) {
        sql = "INSERT INTO DiaChi(Duong, Tinh, ThanhPho, NguoiTao, NguoiSua, NgayTao, NgaySua) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, dc.getDuong());
            ps.setObject(2, dc.getTinh());
            ps.setObject(3, dc.getThanhPho());
            ps.setObject(4, dc.getCreateBy());
            ps.setObject(5, dc.getUpdateBy());
            ps.setObject(6, dc.getCreateAt());
            ps.setObject(7, dc.getUpdateAt());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(DiaChi dc, int id) {
        sql = "UPDATE DiaChi SET Duong = ?, Tinh = ?, ThanhPho = ?, NguoiTao = ?, NguoiSua = ?, NgayTao = ?, NgaySua = ? WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps.setObject(1, dc.getDuong());
            ps.setObject(2, dc.getTinh());
            ps.setObject(3, dc.getThanhPho());
            ps.setObject(4, dc.getCreateBy());
            ps.setObject(5, dc.getUpdateBy());
            ps.setObject(6, dc.getCreateAt());
            ps.setObject(7, dc.getUpdateAt());
            ps.setObject(8, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int id) {
        sql = "DELETE FROM DiaChi WHERE id = ?";
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
