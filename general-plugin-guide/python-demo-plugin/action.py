import base64
import json
import sys

lens = 0
arg = json.loads(base64.b64decode(sys.argv[1]))
for e in arg["body"]["args"]:
    lens += len(e["strValue"])

results = [
    {
        "actionId": "emoji",
        "title": [
            {
                "value": "😃" * lens,
                "type": "PLAIN_TITLE"
            }
        ],
        "callbacks": [
            {
                "actionMethod": "COPY_RESULT"
            }
        ],
    }
]

print(json.dumps(results))
