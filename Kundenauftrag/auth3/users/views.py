# users/views.py
from django.urls import reverse_lazy
from django.views import generic
from school.models import Teacher, Student, Class, Clatea, Subject, Stusu, Exam
from .forms import CustomUserCreationForm, ExamForm
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
def addedExam(request, pk):
    #form = ExamForm(request.POST)
    data=request.POST.copy()
    string= data.get('stusu')
    s=string.split(", ")
    sub=s[0]
    stu=s[1]
    stusu=''
    for i in Stusu.objects.all():
        if(i.subject.name==sub and i.student.name==stu):
            stusu=i
    new_form= Exam(stusu=stusu, name=data.get('name'), grade=data.get('grade'), value=data.get('value'))
    #new_form.is_valid()
    #new_form.full_clean()
    new_form.save()
    if request.user.is_authenticated:
        user=  request.user
    l=''
    for i in Teacher.objects.all():
        if(user.id==i.user.id):
            l=i
    return HttpResponseRedirect(reverse('ClassTeacher', args=(l.id,)))

def home(request):
    #teacher = Group.objects.get(name='teacher')
    #student = Group.objects.get(name='Student')
    if request.user.is_authenticated:
        user=  request.user
    
    for g in user.groups.all():
        l=g.name
    #if user.groups.filter(name=Teacher).exists():
    if l=='Teacher':
        teacher=''
        for t in Teacher.objects.all():
            if(t.user.id==user.id):
                teacher=t
        return HttpResponseRedirect(reverse('TeacherHome', args=(teacher.id,)))
        #return HttpResponse('Nigga Teacher')
    #    return render(request, 'teacher_home.html')
    #    t=loader.get_template('teacher_home.html')

    else: 
        #if user.groups.filter(name=Student).exists():
        if  l=='Student':
            student=''
            for s in Student.objects.all():
                if(s.user.id==user.id):
                    student=s
            return HttpResponseRedirect(reverse('StudentHome', args=(student.id,)))
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

class StudentHome(generic.ListView):
    template_name='student_home.html'
    context_object_name='stusu_list'
    def get_queryset(self):
        s=[]
        pk=self.kwargs['pk']
        for i in Stusu.objects.all():
            stusu=False
            for j in Subject.objects.all():
                if(j.id==i.subject.id and i.student.id == pk):
                    stusu=True
            if(stusu):
                s.append(i)
                stusu=False
        return s

class BackHome(generic.TemplateView):
    template_name='home.html'


class TeacherHome(generic.ListView):
    #tea= get_object_or_404(Teacher, pk=self.kwargs['pk'])
    template_name='teacher_home.html'
    context_object_name= 'class_list'
    def get_queryset(self):
        l=[]
        pk=self.kwargs['pk']
        for i in Class.objects.all():
            clatea=False
            for j in Clatea.objects.all():
                if(j.klasse.class_name==i.class_name and j.teacher.id == pk):
                    clatea=True
            if(clatea):
                l.append(i)
                clatea=False
        return l

class StudentSubject(generic.ListView):
    template_name='studentsubject.html'
    context_object_name='exam_list'
    def get_queryset(self):
        e=[]
        pk=self.kwargs['pk']
        for i in Exam.objects.all():
            if(i.stusu.id==pk):
                e.append(i)
        return e

class TeacherClass(generic.ListView):
    template_name='teacherclass.html'
    context_object_name='student_list'
    def get_queryset(self):
        s=[]
        pk=self.kwargs['pk']
        for i in Student.objects.all():
            if(i.klasse.id==pk):
                s.append(i)
        return s

class TeacherStudent(generic.ListView):
    template_name='teacherstudent.html'
    context_object_name='stuxam_list'
    def get_queryset(self):
        e=[]
        s=[]
        pk=self.kwargs['pk']
        for i in Stusu.objects.all():
            if(i.student.id==pk):
                for j in Exam.objects.all():
                    if(j.stusu.id==i.id):
                        e.append(j)
                s.append(e)
                e=[]
        return s
    
class AddExam(generic.ListView):
    template_name='addexam.html'
    context_object_name='stusu_list'
    def get_queryset(self):
        pk=self.kwargs['pk']
        e=[]
        for i in Stusu.objects.all():
            if(i.student.id==pk):
                e.append(i)
        return e