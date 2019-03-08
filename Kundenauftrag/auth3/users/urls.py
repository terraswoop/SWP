# users/urls.py
from django.urls import path
from . import views

urlpatterns = [
#    path('home/', views.StudentHome.as_view(), name='StudentHome'),
#    path('home/', views.TeacherHome.as_view(), name='TeacherHome'),
    path('home/', views.home, name='logged_home')
]