create database ss02_bai_1;
use ss02_bai_1;
create table nha_cung_cap(
ma_nha_cung_cap int primary key,
ten_nha_cung_cap varchar(50) not null,
dia_chi varchar(50) not null
);
create table so_dien_thoai(
ma_nha_cung_cap int not null,
so_dien_thoai varchar(20) primary key,
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);
create table don_dat_hang(
so_dat_hang int primary key,
ngay_dat_hang date not null,
ma_nha_cung_cap int not null,
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);
create table vat_tu(
ma_vat_tu int primary key,
ten_vat_tu varchar(40) not null
);
create table don_dat_hang_vat_tu(
so_dat_hang int not null,
ma_vat_tu int not null,
primary key (so_dat_hang, ma_vat_tu),
foreign key (so_dat_hang) references don_dat_hang(so_dat_hang),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table phieu_nhap(
so_phieu_nhap int primary key,
ngay_nhap date not null
);
create table vat_tu_phieu_nhap(
ma_vat_tu int not null,
so_phieu_nhap int not null,
primary key (ma_vat_tu, so_phieu_nhap),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
don_gia_nhap varchar(50) not null,
so_luong_nhap varchar(50) not null
);
create table phieu_xuat(
so_phieu_xuat int primary key,
ngay_xuat varchar(50) not null
);
create table vat_tu_phieu_xuat(
ma_vat_tu int not null,
so_phieu_xuat int not null,
primary key (ma_vat_tu, so_phieu_xuat),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key (so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
don_gia_xuat varchar(50) not null,
so_luong_xuat varchar(50) not null
);
-- drop database ss02_bai_1;