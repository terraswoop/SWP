# users/admin.py
from django.contrib import admin
from django.contrib.auth import get_user_model
from django.contrib.auth.admin import UserAdmin
from .models import CustomUser
from .forms import CustomUserCreationForm, CustomUserChangeForm
from school.models import Teacher,Student,Subject,Exam,Teasu,Clasu,Clatea, Class

class CustomUserAdmin(UserAdmin):
    add_form = CustomUserCreationForm
    form = CustomUserChangeForm
    model = CustomUser
    list_display = ['username']

class ClassAdmin(admin.ModelAdmin):
    list_display = ['class_name']

class StudentAdmin(admin.ModelAdmin):
    list_display = ['first_name', 'name']

class TeacherAdmin(admin.ModelAdmin):
    list_display= ['first_name', 'name']

admin.site.register(CustomUser, CustomUserAdmin)
admin.site.register(Class, ClassAdmin)
admin.site.register(Teacher, TeacherAdmin)
admin.site.register(Student, StudentAdmin)
admin.site.register(Subject)
admin.site.register(Exam)
admin.site.register(Teasu)
admin.site.register(Clasu)
admin.site.register(Clatea)