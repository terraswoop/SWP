# users/views.py
from django.urls import reverse_lazy
from django.views import generic
from school.models import Teacher, Student
from .forms import CustomUserCreationForm
from django.template import loader
from django.http import HttpResponse
from django.shortcuts import render

class SignUp(generic.CreateView):
    form_class = CustomUserCreationForm
    success_url = reverse_lazy('login')
    template_name = 'signup.html'


#class StudentHome(generic.TemplateView):
#    template_name = 'student_home.html'

#class TeacherHome(generic.TemplateView):
#    template_name= 'teacher_home.html'


#class Home(generic.TemplateView):
#    if user.groups.filter(name=Teacher).exists():
#        template_name = 'student_home.html'
#    else:
#        template_name = 'teacher_home.html'

def home(request):
    if request.user.is_authenticated:
        user=  request.user
    if user.groups.filter(name=Teacher).exists():
    #    return render(request, 'teacher_home.html')
        t=loader.get_template('teacher_home.html')

    else:
    #    return render(request, 'student_home.html')
        t=loader.get_template('student_home.html')
        
    c = {'foo': 'bar'}
    return HttpResponse(t.render(c, request), content_type='application/xhtml+xml')
    