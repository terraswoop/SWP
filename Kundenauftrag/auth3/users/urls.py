# users/urls.py
from django.urls import path
from . import views

urlpatterns = [
    path('home/logged_s/', views.StudentHome.as_view(), name='StudentHome'),
    path('home/logged_t/', views.TeacherHome.as_view(), name='TeacherHome'),
    path('home/', views.home, name='logged_home')
]