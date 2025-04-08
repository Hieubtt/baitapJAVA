package thuchanh;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class XuLyGiaoDich {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        ArrayList<GiaoDich> dsGiaoDich = new ArrayList<>();
        int tieptuc=1;
        while(tieptuc==1)
        {
        	System.out.println("Nhập mã giao dịch: ");
        	String magd = sc.nextLine();
        	System.out.print("Nhập số lượng: ");
            int sl = Integer.parseInt(sc.nextLine());
            
            
            System.out.print("Chọn loại giao dịch (1: Vàng, 2: Tiền tệ): ");
            int loai = Integer.parseInt(sc.nextLine());
            
            if(loai==1)
            {
            	System.out.print("Nhập loại vàng: ");
            	String loaiVang = sc.nextLine();
            	System.out.print("Nhập đơn giá: ");
            	Double donGia = Double.parseDouble(sc.nextLine());
            	
            	dsGiaoDich.add(new GiaoDichVang(magd, sl, loaiVang, donGia));
            	
            	
            	
            }
            else 
            {
            	System.out.print("Nhập loại tiền: ");
                String loaiTien = sc.nextLine();
                System.out.print("Nhập tỷ giá: ");
                double tiGia = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập loại giao dịch (mua/bán): ");
                String loaiGD = sc.nextLine();

                dsGiaoDich.add(new GiaoDichTienTe(magd, sl, loaiTien, tiGia, loaiGD));
            }
            System.out.println("Bạn muốn tiếp tục hay dừng lại : 1:Có , 2:Không. ");
            tieptuc = Integer.parseInt(sc.nextLine());
        }
        	
        	for(GiaoDich gd : dsGiaoDich)
        	{
        		System.out.println(gd);
        	}
        	
        	System.out.print("\nGhi giao dịch vào file JSON? (1: Có, khác 1: Không): ");
        	int ghi = Integer.parseInt(sc.nextLine());
        	
        	if(ghi==1)
        	{
        		JSONArray arr = new JSONArray();
        		for(GiaoDich gd : dsGiaoDich)
            	{
        			arr.add(gd.toJSON());
            	}
        		
        		FileWriter fw = new FileWriter("APIGiaoDich.json");
        		fw.write(arr.toJSONString());
        		fw.flush();   // Đẩy dữ liệu từ bộ nhớ ra file
        		fw.close();   // Đóng stream
        		System.out.print("Đã ghi file thành công: ");
        		
        	}
        	sc.close();
	}
}