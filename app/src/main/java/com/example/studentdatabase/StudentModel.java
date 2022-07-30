package com.example.studentdatabase;

public class StudentModel {
 String Name;
 int Age;
 String Address;

 public StudentModel(String name, String age, String address) {
  Name = name;
  Age = age;
  Address = address;
 }

 public String getName() {
  return Name;
 }

 public void setName(String name) {
  Name = name;
 }

 public int getAge() {
  return Age;
 }

 public void setAge(int age) {
  Age = age;
 }

 public String getAddress() {
  return Address;
 }

 public void setAddress(String address) {
  Address = address;
 }
}