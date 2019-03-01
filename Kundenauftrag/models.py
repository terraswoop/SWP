from django.db import models

class Class(models.Model):
    class_name = models.CharField(max_length=200)

class Teacher(models.Model):
    name = models.CharField(max_length=200)
    first_name = models.CharField(max_length=200)

class Student(models.Model):
    class_id = models.ForeignKey(Class, on_delete=models.CASCADE)
    name = models.CharField(max_length=200)
    first_name = models.CharField(max_length=200)

class Subject(models.Model):
    name = models.CharField(max_length=200)

class Stusu(models.Model):
    subject_id = models.ForeignKey(Subject, on_delete=models.CASCADE)
    student_id = models.ForeignKey(Student, on_delet=models.CASCADE)

class Exams(models.Model):
    stusu_id = models.ForeignKey(Stusu, on_delete=models.CASCADE)
    grade = models.IntegerField(default=0)

class Teasu(models.Model):
    subject_id = models.ForeignKey(Subject, models.on_delete.CASCADE)
    teacher_id = models.ForeignKey(Teacher, models.on_delete.CASCADE)

class Clasu(models.Model):
    subject_id = models.ForeignKey(Subject, models.on_delete.CASCADE)
    class_id = models.ForeignKey(Class, models.on_delete.CASCADE)

class Clatea(models.Model):
    class_id = models.ForeignKey(Class, on_delete=models.CASCADE)
    teacher_id = models.ForeignKey(Teacher, on_delete=models.CASCADE)
