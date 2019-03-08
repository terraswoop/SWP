from django.db import models
from django.db.models.fields import related
from django.db.models.fields.related import ForeignKey
from users.models import CustomUser

class Class(models.Model):
    class_name = models.CharField(max_length=200)

class Teacher(models.Model):
    name = models.CharField(max_length=200)
    first_name = models.CharField(max_length=200)
    user = related.ForeignKey(CustomUser, on_delete=models.CASCADE)

class Student(models.Model):
    class_id = models.ForeignKey(Class, on_delete=models.CASCADE)
    name = models.CharField(max_length=200)
    first_name = models.CharField(max_length=200)
    user = related.ForeignKey(CustomUser, on_delete=models.CASCADE)

class Subject(models.Model):
    name = models.CharField(max_length=200)

class Stusu(models.Model):
    subject = models.ForeignKey(Subject, on_delete=models.CASCADE)
    student = models.ForeignKey(Student, on_delete=models.CASCADE)

class Exams(models.Model):
    stusu = models.ForeignKey(Stusu, on_delete=models.CASCADE)
    name = models.CharField(max_length=200)
    grade = models.IntegerField(default=0)

class Teasu(models.Model):
    subject = models.ForeignKey(Subject, on_delete=models.CASCADE)
    teacher = models.ForeignKey(Teacher, on_delete=models.CASCADE)

class Clasu(models.Model):
    subject = models.ForeignKey(Subject, on_delete=models.CASCADE)
    klasse = models.ForeignKey(Class, on_delete=models.CASCADE)

class Clatea(models.Model):
    klasse = models.ForeignKey(Class, on_delete=models.CASCADE)
    teacher = models.ForeignKey(Teacher, on_delete=models.CASCADE)