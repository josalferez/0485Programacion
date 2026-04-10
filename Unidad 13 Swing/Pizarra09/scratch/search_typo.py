import os

def search_typo(root_dir):
    for root, dirs, files in os.walk(root_dir):
        for file in files:
            if file.endswith(('.java', '.xml', '.md', '.sql')):
                try:
                    with open(os.path.join(root, file), 'r', encoding='utf-8') as f:
                        content = f.read()
                        if 'alummno' in content:
                            print(f"Found typo in {os.path.join(root, file)}")
                except:
                    pass

search_typo('.')
