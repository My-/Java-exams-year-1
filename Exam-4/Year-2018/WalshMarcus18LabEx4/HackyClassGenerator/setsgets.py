#!/usr/bin/env python3

def capital_letter(inp):
    return inp[0].upper() + inp[1:]


def gen_getter(member_name, member_type):
    out = '''
    public {member_type} get{member_name2}()
    {{
        return {member_name};
    }}'''

    member_name2 = capital_letter(member_name)
    return out.format(
        member_type=member_type, member_name=member_name, member_name2=member_name2)


def gen_setter(member_name, member_type):
    out = '''
    public void set{member_name2}({params})
    {{
        {member_name} = {arg_name};
    }}'''

    arg_name = member_name[0];
    params = member_type + ' ' + arg_name
    member_name2 = capital_letter(member_name)
    return out.format(
        member_name=member_name, member_name2=member_name2, params=params, arg_name=arg_name)


def gen_sets_gets(member_name, member_type):
    blacklisted_types = ['static']

    for x in blacklisted_types:
        if member_type.startswith(x):
            return ''

    setter = gen_setter(member_name, member_type)
    getter = gen_getter(member_name, member_type)
    return setter + '\n' + getter
