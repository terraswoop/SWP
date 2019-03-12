# users/views.py
from django.urls import reverse_lazy
from django.views import generic
from school.models import Teacher, Student
from .forms import CustomUserCreationForm
from django.template import loader
from django.http import HttpResponse, HttpResponseRedirect
from django.urls import reverse
from django.shortcuts import render
from django.contrib.auth.models import Group
from django.contrib.auth.decorators import user_passes_test


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
    #teacher = Group.objects.get(name='teacher')
    #student = Group.objects.get(name='Student')
    if request.user.is_authenticated:
        user=  request.user
    
    for g in user.groups.all():
        l=g.name
    #if user.groups.filter(name=Teacher).exists():
    if l=='Teacher':
        return HttpResponseRedirect(reverse('TeacherHome',args=None))
        #return HttpResponse('Nigga Teacher')
    #    return render(request, 'teacher_home.html')
    #    t=loader.get_template('teacher_home.html')

    else: 
        #if user.groups.filter(name=Student).exists():
        if  l=='Student':
            return HttpResponseRedirect(reverse('StudentHome', args=None))
            #return HttpResponse('Nigga Student')
    #    return render(request, 'student_home.html')
    #    t=loader.get_template('student_home.html')
        else: 
            return HttpResponse('Not signed to a group yet!')
    #c = {'foo': 'bar'}
    #return HttpResponse(t.render(c, request), content_type='application/xhtml+xml')

def student_check(user):
    return 'Student' in user.groups.all()

def teacher_check(user):
    return 'Teacher' in user.groups.all()

#@user_passes_test(student_check)
#def StudentHome(request):
#    #template_name='student_home.html'
#    template = loader.get_template('student_home.html')
#    return HttpResponse(template.render())

#@user_passes_test(teacher_check)
#def TeacherHome(request):
    #template_name='teacher_home.html'
#   template = loader.get_template('teacher_home.html')
#   return HttpResponse(template.render())

class StudentHome(generic.TemplateView):
    template_name='student_home.html'

class TeacherHome(generic.TemplateView):
    template_name='teacher_home.html'