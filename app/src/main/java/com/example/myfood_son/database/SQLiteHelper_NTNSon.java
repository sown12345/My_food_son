package com.example.myfood_son.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper_NTNSon extends SQLiteOpenHelper {
    public static final String DB_NAME = "FoodExample_NHMAnh";
    public static final int DB_VERSION = 1;

    public SQLiteHelper_NTNSon(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String User_NHMAnh = "CREATE TABLE User(" +
                "UserID text primary key, " +
                "User_Name text not null, " +
                "Gender text, " +
                "Date_of_birth text, " +
                "User_Phone text, " +
                "Username text not null, " +
                "Password text not null )";
        sqLiteDatabase.execSQL(User_NHMAnh);

        String Restaurant_NHMAnh = "CREATE TABLE Restaurant(" +
                "ResID text primary key, " +
                "Res_Name text not null, " +
                "Res_Address text, " +
                "Res_Phone text, " +
                "Res_Image text )";
        sqLiteDatabase.execSQL(Restaurant_NHMAnh);

        String Food_NHMAnh = "CREATE TABLE Food(" +
                "FoodID text primary key, " +
                "Food_Name text not null, " +
                "Type text, " +
                "Description text, " +
                "Food_Image text, " +
                "ResID text, " +
                "foreign key (ResID) references Restaurant_NHMAnh (ResID)" + ")";
        sqLiteDatabase.execSQL(Food_NHMAnh);

        String Order_NHMAnh = "CREATE TABLE `Order`(" +
                "OrderID text primary key, " +
                "Order_Address text, " +
                "Date_order text, " +
                "Total_value real, " +
                "Status text, " +
                "UserID text, " +
                "foreign key (UserID) references User_NHMAnh (UserID)" + ")";
        sqLiteDatabase.execSQL(Order_NHMAnh);

        String OrderDetail_NHMAnh = "CREATE TABLE OrderDetail(" +
                "OrderID text, " +
                "FoodID text, " +
                "Size text, " +
                "OrderDetail_Food text, " +
                "Quantity integer, " +
                "primary key (OrderID, FoodID), " +
                "foreign key (OrderID) references Order_NHMAnh (OrderID), " +
                "foreign key (FoodID) references Food_NHMAnh (FoodID)" + ")";
        sqLiteDatabase.execSQL(OrderDetail_NHMAnh);

        insertData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS OrderDetail");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS `Order`");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Food");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Restaurant");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS User");
        onCreate(sqLiteDatabase);
    }

    private void insertData(SQLiteDatabase sqLiteDatabase){
        ContentValues user1 = new ContentValues();
        user1.put("UserID", "U001");
        user1.put("User_Name", "Nguyễn Văn A");
        user1.put("Gender", "Nam");
        user1.put("Date_of_birth", "15/01/1990");
        user1.put("User_Phone", "0901234567");
        user1.put("Username", "nva");
        user1.put("Password", "nva123");
        sqLiteDatabase.insert("User", null, user1);

        ContentValues user2 = new ContentValues();
        user2.put("UserID", "U002");
        user2.put("User_Name", "Trần Thị B");
        user2.put("Gender", "Nữ");
        user2.put("Date_of_birth", "20/03/1992");
        user2.put("User_Phone", "0912345678");
        user2.put("Username", "ttb");
        user2.put("Password", "ttb123");
        sqLiteDatabase.insert("User", null, user2);

        ContentValues user3 = new ContentValues();
        user3.put("UserID", "U003");
        user3.put("User_Name", "Lê Văn C");
        user3.put("Gender", "Nam");
        user3.put("Date_of_birth", "10/07/1988");
        user3.put("User_Phone", "0923456789");
        user3.put("Username", "lvc");
        user3.put("Password", "lvc123");
        sqLiteDatabase.insert("User", null, user3);

        ContentValues user4 = new ContentValues();
        user4.put("UserID", "U004");
        user4.put("User_Name", "Phạm Thị D");
        user4.put("Gender", "Nữ");
        user4.put("Date_of_birth", "25/11/1995");
        user4.put("User_Phone", "0934567890");
        user4.put("Username", "ptd");
        user4.put("Password", "ptd123");
        sqLiteDatabase.insert("User", null, user4);

        ContentValues user5 = new ContentValues();
        user5.put("UserID", "U005");
        user5.put("User_Name", "Hoàng Văn E");
        user5.put("Gender", "Nam");
        user5.put("Date_of_birth", "30/04/1993");
        user5.put("User_Phone", "0945678901");
        user5.put("Username", "hve");
        user5.put("Password", "hve123");
        sqLiteDatabase.insert("User", null, user5);

        ContentValues restaurant1 = new ContentValues();
        restaurant1.put("ResID", "R001");
        restaurant1.put("Res_Name", "Bánh Mì Cô Ba");
        restaurant1.put("Res_Address", "68 Bùi Thị Xuân, Tân Bình");
        restaurant1.put("Res_Phone", "0631335935");
        restaurant1.put("Res_Image", "banh_mi_co_ba.jpg");
        sqLiteDatabase.insert("Restaurant", null, restaurant1);

        ContentValues restaurant2 = new ContentValues();
        restaurant2.put("ResID", "R002");
        restaurant2.put("Res_Name", "Phở Hà Nội");
        restaurant2.put("Res_Address", "123 Lê Lợi, Quận 1");
        restaurant2.put("Res_Phone", "0901234567");
        restaurant2.put("Res_Image", "pho_ha_noi.jpg");
        sqLiteDatabase.insert("Restaurant", null, restaurant2);

        ContentValues restaurant3 = new ContentValues();
        restaurant3.put("ResID", "R003");
        restaurant3.put("Res_Name", "Cơm Tấm Sài Gòn");
        restaurant3.put("Res_Address", "45 Nguyễn Huệ, Quận 1");
        restaurant3.put("Res_Phone", "0912345678");
        restaurant3.put("Res_Image", "com_tam_sai_gon.jpg");
        sqLiteDatabase.insert("Restaurant", null, restaurant3);

        ContentValues restaurant4 = new ContentValues();
        restaurant4.put("ResID", "R004");
        restaurant4.put("Res_Name", "Hủ Tiếu Nam Vang");
        restaurant4.put("Res_Address", "78 Trần Hưng Đạo, Quận 5");
        restaurant4.put("Res_Phone", "0923456789");
        restaurant4.put("Res_Image", "hu_tieu_nam_vang.jpg");
        sqLiteDatabase.insert("Restaurant", null, restaurant4);

        ContentValues restaurant5 = new ContentValues();
        restaurant5.put("ResID", "R005");
        restaurant5.put("Res_Name", "Bún Bò Huế");
        restaurant5.put("Res_Address", "56 Phạm Văn Đồng, Gò Vấp");
        restaurant5.put("Res_Phone", "0934567890");
        restaurant5.put("Res_Image", "bun_bo_hue.jpg");
        sqLiteDatabase.insert("Restaurant", null, restaurant5);

        ContentValues food1 = new ContentValues();
        food1.put("FoodID", "F001");
        food1.put("Food_Name", "Bánh Mì Bò Kho");
        food1.put("Type", "Bữa sáng");
        food1.put("Description", "Bánh mì với bò kho thơm ngon");
        food1.put("Food_Image", "banh_mi_bo_kho.jpg");
        food1.put("ResID", "R001");
        sqLiteDatabase.insert("Food", null, food1);

        ContentValues food2 = new ContentValues();
        food2.put("FoodID", "F002");
        food2.put("Food_Name", "Bánh Mì Ốp La");
        food2.put("Type", "Bữa sáng");
        food2.put("Description", "Bánh mì với trứng ốp la");
        food2.put("Food_Image", "banh_mi_op_la.jpg");
        food2.put("ResID", "R001");
        sqLiteDatabase.insert("Food", null, food2);

        ContentValues food3 = new ContentValues();
        food3.put("FoodID", "F003");
        food3.put("Food_Name", "Phở Bò");
        food3.put("Type", "Bữa trưa");
        food3.put("Description", "Phở bò truyền thống Hà Nội");
        food3.put("Food_Image", "pho_bo.jpg");
        food3.put("ResID", "R002");
        sqLiteDatabase.insert("Food", null, food3);

        ContentValues food4 = new ContentValues();
        food4.put("FoodID", "F004");
        food4.put("Food_Name", "Phở Gà");
        food4.put("Type", "Bữa trưa");
        food4.put("Description", "Phở gà thơm ngon");
        food4.put("Food_Image", "pho_ga.jpg");
        food4.put("ResID", "R002");
        sqLiteDatabase.insert("Food", null, food4);

        ContentValues food5 = new ContentValues();
        food5.put("FoodID", "F005");
        food5.put("Food_Name", "Cơm Tấm Sườn");
        food5.put("Type", "Bữa tối");
        food5.put("Description", "Cơm tấm với sườn nướng");
        food5.put("Food_Image", "com_tam_suon.jpg");
        food5.put("ResID", "R003");
        sqLiteDatabase.insert("Food", null, food5);

        ContentValues food6 = new ContentValues();
        food6.put("FoodID", "F006");
        food6.put("Food_Name", "Cơm Tấm Trứng");
        food6.put("Type", "Bữa tối");
        food6.put("Description", "Cơm tấm với trứng ốp la");
        food6.put("Food_Image", "com_tam_trang.jpg");
        food6.put("ResID", "R003");
        sqLiteDatabase.insert("Food", null, food6);

        ContentValues food7 = new ContentValues();
        food7.put("FoodID", "F007");
        food7.put("Food_Name", "Hủ Tiếu Bò");
        food7.put("Type", "Bữa nhẹ");
        food7.put("Description", "Hủ tiếu bò Nam Vang");
        food7.put("Food_Image", "hu_tieu_bo.jpg");
        food7.put("ResID", "R004");
        sqLiteDatabase.insert("Food", null, food7);

        ContentValues food8 = new ContentValues();
        food8.put("FoodID", "F008");
        food8.put("Food_Name", "Hủ Tiếu Hải Sản");
        food8.put("Type", "Bữa nhẹ");
        food8.put("Description", "Hủ tiếu với hải sản tươi");
        food8.put("Food_Image", "hu_tieu_hai_san.jpg");
        food8.put("ResID", "R004");
        sqLiteDatabase.insert("Food", null, food8);

        ContentValues food9 = new ContentValues();
        food9.put("FoodID", "F009");
        food9.put("Food_Name", "Bún Chả Cá");
        food9.put("Type", "Bữa khuya");
        food9.put("Description", "Bún với chả cá thơm ngon");
        food9.put("Food_Image", "bun_cha_ca.jpg");
        food9.put("ResID", "R005");
        sqLiteDatabase.insert("Food", null, food9);

        ContentValues food10 = new ContentValues();
        food10.put("FoodID", "F0010");
        food10.put("Food_Name", "Bánh Xèo");
        food10.put("Type", "Bữa khuya");
        food10.put("Description", "Bánh xèo chiên giòn");
        food10.put("Food_Image", "banh_xeo.jpg");
        food10.put("ResID", "R005");
        sqLiteDatabase.insert("Food", null, food10);
    }
}

