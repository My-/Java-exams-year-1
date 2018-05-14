#!/usr/bin/env python3
from setsgets import *
from templates import *

'''
Hacky class generator that sort-of works that was thrown together in a few minutes but served me well in the exam.

* Constructors are blank and calls to the setter have to be manually added
* The default values for the member variable setter calls are all strings of the member variable names
* Some formal parameters need to be renamed IIRC

Probably best to write your own generator so you know how it works etc.
'''

def capital_letter(inp):
    return inp[0].upper() + inp[1:]

def gen_setter_call(member_var_name):
    out = '{methodName}("{methodName}");'
    method_name = 'set' + capital_letter(member_var_name)

    return out.format(methodName=method_name)


def gen_constructor_setter(className, args):
    out = '''
    public void set{className2}({args})
    {{
        {setMethods}
    }}
    '''
    set_methods = '\n        '.join([gen_setter_call(k) for k,v in args.items()])
    args_out = ', '.join([v + ' ' + k for k,v in args.items()])

    className2 = capital_letter(className)
    return out.format(className2=className2, args=args_out, setMethods=set_methods)


def gen_constructor(className, args = {}):
    args_out = ', '.join([v + ' ' + k for k,v in args.items()])

    out = constructor_template.format(
        className = className,
        args      = args_out)

    if args_out:
        # this needs to happen in gen_class
        out += gen_constructor_setter(className, args)

    return out


def gen_member_variable(member_name, member_type):
    return member_var_template.format(
        name        = member_name,
        member_type = member_type)


def gen_class(className, args):
    member_variables, setsgets = [], []

    for k,v in args.items():
        member_variables += [gen_member_variable(k,v)]
        setsgets         += [gen_sets_gets(k,v)]

    member_variables = '\n    '.join(member_variables)
    setsgets         = '\n    '.join(setsgets)

    constructors  = gen_constructor(className)
    constructors += gen_constructor(className, args)

    return class_template.format(
        className    = className,
        memberVars   = member_variables,
        getters      = setsgets,
        constructors = constructors)


def main():
    # Edit here, member veriable name & type
    args = {
        'firstName': 'String',
        'lastName': 'String',
        'dateOfBirth': 'int',
    }
    class_name = "Person"

    class_data = gen_class(class_name, args)
    print(class_data)
    with open(class_name+'.java','w') as f:
        f.write(class_data)


if __name__ == '__main__':
    main()
