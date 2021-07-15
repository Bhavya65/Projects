package net.javaguides.usermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */

@Entity
@Table(name="instructor")
public class User {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
 protected int id;
 
 @Column(name="file")
 protected String file;
 
 @Column(name="image")
 protected String image;
 
 @Column(name="size")
 protected String size;
 
 public User() {
 }
 
 public User(String file, String image, String size) {
  super();
  this.file = file;
  this.image = image;
  this.size = size;
 }

 public User(int id, String file, String image, String size) {
  super();
  this.id = id;
  this.file = file;
  this.image = image;
  this.size = size;
 }

 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 public String getfile() {
  return file;
 }
 public void setfile(String file) {
  this.file = file;
 }
 public String getimage() {
  return image;
 }
 public void setimage(String image) {
  this.image = image;
 }
 public String getsize() {
  return size;
 }
 public void setsize(String size) {
  this.size = size;
 }
}
