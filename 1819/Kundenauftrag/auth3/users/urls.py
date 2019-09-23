# users/urls.py
from django.urls import path
from . import views
from django.contrib import admin  
  
urlpatterns = [
    path('home/logged_s/<int:pk>', views.StudentHome.as_view(), name='StudentHome'),
    path('home/logged_s/subject/<int:pk>', views.StudentSubject.as_view(), name='StudentSubject'),
    path('home/logged_t/<int:pk>', views.TeacherHome.as_view(), name='TeacherHome'),
    path('home/logged_t/class/<int:pk>', views.TeacherClass.as_view(), name='ClassTeacher'),
    path('home/logged_t/class/add_exam/<int:pk>', views.AddExam.as_view(), name='AddExam'),
    path('home/logged_t/class/added_exam/<int:pk>', views.addedExam, name='AddedExam'),
    path('home/logged_t/class/student/<int:pk>', views.TeacherStudent.as_view(), name='TeacherStudent'),
    path('home/logged_t/class/student/delete_exam/<int:pk>', views.deleteExam, name='DeleteExam'),
    path('home/logged_t/class_list/<int:pk>', views.ClassList.as_view(), name='ListClass'),
    path('home/logged_t/class_list/subject/<int:pk>', views.MarkTable.as_view(), name='MarkTable'),
    path('home/', views.home, name='logged_home'),
    path('', views.BackHome.as_view(), name='BackHome'),
    path('admin/', admin.site.urls, name="admin")
]