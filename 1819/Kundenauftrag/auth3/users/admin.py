# users/admin.py
from django.contrib import admin
from django.contrib.auth import get_user_model
from django.contrib.auth.admin import UserAdmin
from .models import CustomUser
from .forms import CustomUserCreationForm, CustomUserChangeForm
from school.models import Teacher,Student,Subject,Exam,Teasu,Clasu,Clatea, Class, Stusu

class CustomUserAdmin(UserAdmin):
    add_form = CustomUserCreationForm
    form = CustomUserChangeForm
    model = CustomUser
    list_display = ['username']

class ClassAdmin(admin.ModelAdmin):
    list_display = ['class_name']
    search_fields=('class_name',)

class StudentAdmin(admin.ModelAdmin):
    list_display = ['first_name', 'name']
    search_fields=('name',)

class TeacherAdmin(admin.ModelAdmin):
    list_display= ['first_name', 'name']
    search_fields=('name',)

class StusuAdmin(admin.ModelAdmin):
    search_fields=('student__name','subject__name')

class TeasuAdmin(admin.ModelAdmin):
    search_fields=('teacher__name','subject__name')

class SubjectAdmin(admin.ModelAdmin):
    search_fields=('name',)
    
class ExamAdmin(admin.ModelAdmin):
    search_fields=('name',)

class ClasuAdmin(admin.ModelAdmin):
    search_fields=('klasse__class_name','subject__name')

class ClateaAdmin(admin.ModelAdmin):
    search_fields=('klasse__class_name','teacher__name')

admin.site.register(CustomUser, CustomUserAdmin)
admin.site.register(Class, ClassAdmin)
admin.site.register(Teacher, TeacherAdmin)
admin.site.register(Student, StudentAdmin)
admin.site.register(Subject, SubjectAdmin)
admin.site.register(Exam, ExamAdmin)
admin.site.register(Teasu, TeasuAdmin)
admin.site.register(Clasu, ClasuAdmin)
admin.site.register(Clatea, ClateaAdmin)
admin.site.register(Stusu, StusuAdmin)
