from django.db import models
from django.db.models.fields import related
from django.db.models.fields.related import ForeignKey
from users.models import CustomUser

class Class(models.Model):
    class_name = models.CharField(max_length=200)
    def __str__(self):
        return self.class_name
    class Meta:    
        verbose_name="Classe"

class Teacher(models.Model):
    name = models.CharField(max_length=200)
    first_name = models.CharField(max_length=200)
    user = related.ForeignKey(CustomUser, on_delete=models.CASCADE)
    def __str__(self):
        return self.name

class Student(models.Model):
    klasse = models.ForeignKey(Class, on_delete=models.CASCADE)
    name = models.CharField(max_length=200)
    first_name = models.CharField(max_length=200)
    user = related.ForeignKey(CustomUser, on_delete=models.CASCADE)
    def __str__(self):
        return self.name

class Subject(models.Model):
    name = models.CharField(max_length=200)
    def __str__(self):
        return self.name

class Stusu(models.Model):
    subject = models.ForeignKey(Subject, on_delete=models.CASCADE)
    student = models.ForeignKey(Student, on_delete=models.CASCADE)
    def __str__(self):
        return self.subject.__str__()+", "+ self.student.__str__()
    class Meta:
        verbose_name="Students with Subject"

class Exam(models.Model):
    stusu = models.ForeignKey(Stusu, on_delete=models.CASCADE)
    name = models.CharField(max_length=200)
    grade = models.IntegerField(default=0)
    value = models.IntegerField(default=0)
    def __str__(self):
        return self.name

class Teasu(models.Model):
    subject = models.ForeignKey(Subject, on_delete=models.CASCADE)
    teacher = models.ForeignKey(Teacher, on_delete=models.CASCADE)
    def __str__(self):
        return self.subject.__str__()+", "+ self.teacher.__str__()
    class Meta:
        verbose_name="Teachers with Subject"

class Clasu(models.Model):
    subject = models.ForeignKey(Subject, on_delete=models.CASCADE)
    klasse = models.ForeignKey(Class, on_delete=models.CASCADE)
    def __str__(self):
        return self.subject.__str__() +", "+ self.klasse.__str__()
    class Meta:
        verbose_name="Classes with Subject"


class Clatea(models.Model):
    klasse = models.ForeignKey(Class, on_delete=models.CASCADE)
    teacher = models.ForeignKey(Teacher, on_delete=models.CASCADE)
    def __str__(self):
        return self.klasse.__str__() +", " +self.teacher.__str__()
    class Meta:    
        verbose_name="Classes with Teacher"
    