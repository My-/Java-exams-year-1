#!/usr/bin/env python3

class_template = '''
public class {className} {{
    // Member Variables
    {memberVars}

    // Constructors
    {constructors}
    // Setters and getters
    {getters}

}}
'''

constructor_template = '''
    public {className}({args})
    {{
    }}
'''

member_var_template = 'public {member_type} {name};'
