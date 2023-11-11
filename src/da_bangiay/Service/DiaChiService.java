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
        sql = "SELECT id, id_KhachHang, Duong, ThanhPho, Tinh, QuocGia, Status, Create_by, LanSuaCuoi, Create_at, Deleted FROM tbl_DiaChi";
        List<DiaChi> listdc = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DiaChi dc = new DiaChi(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getDate(10), rs.getInt(11));
                listdc.add(dc);
            }
            return listdc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DiaChi getDC(int id) {
        sql = "SELECT tbl_DiaChi.id, id_KhachHang, Duong, ThanhPho, Tinh, QuocGia, Status, tbl_DiaChi.Create_by, LanSuaCuoi, tbl_DiaChi.Create_at, Deleted FROM tbl_DiaChi WHERE tbl_DiaChi.id = ?";
        DiaChi dc = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                dc = new DiaChi(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getDate(10), rs.getInt(11));
            }
            return dc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insert(DiaChi dc) {
        sql = "INSERT INTO dbo.tbl_DiaChi(id, id_KhachHang, Duong, ThanhPho, Tinh, QuocGia, Status, Create_by, LanSuaCuoi, Create_at, Deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, dc.getId());
            ps.setObject(2, dc.getIdKH());
            ps.setObject(3, dc.getDuong());
            ps.setObject(4, dc.getThanhPho());
            ps.setObject(5, dc.getTinh());
            ps.setObject(6, dc.getQuocGia());
            ps.setObject(7, dc.getTrangThai());
            ps.setObject(8, dc.getCreateBy());
            ps.setObject(9, dc.getLanSC());
            ps.setObject(10, dc.getCreateAt());
            ps.setObject(11, dc.getDeleted());
            ps.setObject(9, dc.getCreateAt());
            ps.setObject(9, dc.getDeleted());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(DiaChi dc, int id) {
        sql = "UPDATE tbl_DiaChi SET Duong = ?, ThanhPho = ?, Tinh = ?, QuocGia = ?, Status = ?, Create_by = ?, LanSuaCuoi = ?, Create_at = ?, Deleted = ? WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps.setObject(1, dc.getDuong());
            ps.setObject(2, dc.getThanhPho());
            ps.setObject(3, dc.getTinh());
            ps.setObject(4, dc.getQuocGia());
            ps.setObject(5, dc.getTrangThai());
            ps.setObject(6, dc.getCreateBy());
            ps.setObject(7, dc.getLanSC());
            ps.setObject(8, dc.getCreateAt());
            ps.setObject(9, dc.getDeleted());
            ps.setObject(10, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int id) {
        sql = "DELETE FROM tbl_DiaChi WHERE id = ?";
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
